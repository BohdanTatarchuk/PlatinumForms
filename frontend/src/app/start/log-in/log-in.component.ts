import {Component, inject} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Router, RouterOutlet} from '@angular/router';
import {GlobalService} from '../../services/global.service';
import {DUMMY_TESTS} from '../../main/my-tests/my-test/dummy-data';
import {gapi, loadGapiInsideDOM} from 'gapi-script';

@Component({
  selector: 'app-log-in',
  standalone: true,
  imports: [
    FormsModule,
    RouterOutlet
  ],
  templateUrl: './log-in.component.html',
  styleUrl: './log-in.component.css'
})
export class LogInComponent {

  router = inject(Router)

  constructor(public globalService: GlobalService) {
  }

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
    this.globalService.is_logged = true;
    this.globalService.email = profile.getEmail();
    this.globalService.username = profile.getName();
    this.globalService.photo = profile.getImageUrl();
    console.log(profile.getEmail());
    console.log(profile.getName());
    console.log(profile.getImageUrl());
    this.router.navigate(['/main']);
  }

  users = DUMMY_TESTS;

  data_check() {
    const info = this.users.find(user => user.email == this.data.email)
    if (info?.email == this.data.email && info?.password == this.data.password) {
      this.globalService.is_logged = true;
      this.globalService.email = this.data.email;
      this.router.navigate(['/main']);
    } else console.log("AAAAAAAAAA")
  }

  navigateToRegistration() {
    this.router.navigate(['/registration']);
  }

}
