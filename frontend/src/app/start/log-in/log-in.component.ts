import {Component, inject} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Router, RouterOutlet} from '@angular/router';
import {GlobalService} from '../../services/global.service';
import {gapi, loadGapiInsideDOM} from 'gapi-script';
import {NgIf} from '@angular/common';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UserT} from '../../registration/registration-window/user.model';
import {firstValueFrom, Observable} from 'rxjs';

const URL: string = 'http://localhost:8080';

@Component({
  selector: 'app-log-in',
  standalone: true,
  imports: [
    FormsModule,
    RouterOutlet,
    NgIf
  ],
  templateUrl: './log-in.component.html',
  styleUrl: './log-in.component.css'
})
export class LogInComponent {

  router = inject(Router);
  private httpClient = inject(HttpClient);

  constructor(public globalService: GlobalService) {
  }

  public wrong_password: boolean = false;
  public error_message: string = "Wrong credentials, please try again.";

  data = {
    email: '',
    password: ''
  }

  ngOnInit() {
    loadGapiInsideDOM().then(() => {
      gapi.load('auth2', () => {
        gapi.auth2.init({
          client_id: '615371380297-rt8hqcr3o2i972rgobehnmudi2kl2d8i.apps.googleusercontent.com',
          scope: 'profile email',
          ux_mode: 'popup'
        });
      });
    });
  }

  async handleGoogleSignIn() {
    const auth2 = gapi.auth2.getAuthInstance();
    const googleUser = await auth2.signIn();
    const profile = googleUser.getBasicProfile();

    console.log('Google profile:', profile.getName(), profile.getEmail(), profile.getImageUrl());

    let user: UserT | null = null;
    try {
      user = await firstValueFrom(this.getUser(profile.getEmail()));
      console.log('User retrieved from backend:', user);
    } catch (error) {
      console.error('Error fetching user:', error);
    }

    if (!user) {
      const newUser: UserT = {
        username: profile.getName(),
        email: profile.getEmail(),
        photo: profile.getImageUrl(),
        password: ""
      };
      sessionStorage.setItem('email', profile.getEmail());
      sessionStorage.setItem('photo', profile.getImageUrl());
      sessionStorage.setItem('username', profile.getName());
      this.createUser(newUser);
    }

    await this.router.navigate(['/main']);
  }

  data_check() {
     this.getUser(this.data.email).subscribe({
      next: (user) => {
        console.log('User retrieved:', user);
        if (user.password === this.data.password) {
          sessionStorage.setItem('email', user.email);
          sessionStorage.setItem('photo', user.photo);
          sessionStorage.setItem('username', user.username);
          this.router.navigate(['/main']);
        } else {
          this.error_message = "Wrong credentials, please try again.";
          this.wrong_password = true;
        }
      }
    });
  }

  navigateToRegistration() {
    this.router.navigate(['/registration']);
  }

  getUser(email: string): Observable<UserT> {
    return this.httpClient.get<UserT>(URL + "/users/" + email);
  }

  createUser(user: UserT) {
    const header = new HttpHeaders({'Content-Type': 'application/json'});
    console.log("createUser: " + user);
    this.httpClient.post(URL + "/users/", user, {headers : header}).subscribe(res => {
      console.log("POST: " + res);
    });
  }

}
