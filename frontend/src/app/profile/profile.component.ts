import {Component, inject} from '@angular/core';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {GlobalService} from '../services/global.service';
import {Router} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {UserT} from '../registration/registration-window/user.model';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

const URL: string = 'http://localhost:8080';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [
    TopHeaderComponent,
    FormsModule
  ],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {
  constructor(public globalService: GlobalService) {}

  router = inject(Router)
  private httpClient = inject(HttpClient);

  imageUrl: string | null = "";
  username: string | null = "";
  email: string | null = "";
  newUsername: string = "";
  emptyError: string = "";
  newPassword: string = "";

  newUser: UserT = {
    username: '',
    email: '',
    password: '',
    photo: ''
  };


  ngOnInit(){
    this.imageUrl = sessionStorage.getItem("photo");
    this.username = sessionStorage.getItem("username");
    this.email = sessionStorage.getItem("email");
  }

  async onFileSelected(event: Event): Promise<void> {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];
      const reader = new FileReader();
      reader.onload = (e: any) => {
        this.imageUrl = sessionStorage.getItem("photo");
        this.imageUrl = e.target.result;
        if (typeof this.imageUrl === "string") {
          sessionStorage.setItem("photo", this.imageUrl);
          console.log("Photo :" + this.imageUrl);
          this.updateUserPhoto(<string>this.imageUrl);
        }
      };
      reader.readAsDataURL(file);
    }
  }

  logout() {
    sessionStorage.setItem("photo", "");
    sessionStorage.setItem("username", "");
    sessionStorage.setItem("email", "");
    this.router.navigate(['/']);
  }

  changeUsername() {
    if (this.newUsername) {
      sessionStorage.setItem("username",this.newUsername);
      this.username = this.newUsername;
      this.emptyError = "";
      this.updateUsername(this.newUsername);
    } else {
      this.emptyError = "Username can not be empty";
    }
  }

  updateUserPhoto(photo: string) {
    this.getUser(<string>this.email).subscribe({
      next: (user) => {
        console.log("User retrieved: ", user);

        this.newUser = {
          email: user.email,
          photo: photo,
          username: user.username,
          password: user.password
        };

        this.httpClient.put<UserT>(`${URL}/users/${this.email}`, this.newUser).subscribe({
          next: (info) => {
            console.log("Info :", info);
          }
        });
      }
    });
  }

  updateUsername(username: string) {
    this.getUser(<string>this.email).subscribe({
      next: (user) => {
        console.log("User retrieved: ", user);

        this.newUser = {
          email: user.email,
          photo: user.photo,
          username: username,
          password: user.password
        };

        this.httpClient.put<UserT>(`${URL}/users/${this.email}`, this.newUser).subscribe({
          next: (info) => {
            console.log("Info :", info);
          }
        });
      }
    });
  }


  getUser(email: string): Observable<UserT> {
    return this.httpClient.get<UserT>(URL + "/users/" + email);
  }

  changePassword() {

  }
}
