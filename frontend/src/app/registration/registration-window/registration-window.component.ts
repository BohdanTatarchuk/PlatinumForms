import {Component, inject} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Router} from '@angular/router';
import {GlobalService} from '../../services/global.service';
import {CommonModule} from '@angular/common';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserT} from './user.model';

const URL: string = 'http://localhost:8080';

@Component({
  selector: 'app-registration-window',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule
  ],
  templateUrl: './registration-window.component.html',
  styleUrls: ['./registration-window.component.css']
})
export class RegistrationWindowComponent {

  router = inject(Router);
  private httpClient = inject(HttpClient);

  info = {
    email: '',
    username: '',
    password: '',
    repeated_password: ''
  };

  public correct_email: boolean = false;
  public correct_password: boolean = false;
  public correctly_repeated: boolean = false;
  public email_message: string = "";
  public password_message: string = "";
  public repeated_password_message: string = "Passwords do not match";

  password_validation() {
    let hasLowerChars = false;
    let hasUpperChars = false;
    let hasSpecialChars = false;
    let hasNumbers = false;

    for (const char of this.info.password) {
      if (/[a-z]/.test(char)) hasLowerChars = true;
      if (/[A-Z]/.test(char)) hasUpperChars = true;
      if (/[0-9]/.test(char)) hasNumbers = true;
      if (/[^a-zA-Z0-9]/.test(char)) hasSpecialChars = true;
    }

    let messages: string[] = [];

    if (this.info.password.length < 8) {
      messages.push("Password is too short")
    }
    if (!hasLowerChars) {
      messages.push("No lowercase characters");
    }
    if (!hasUpperChars) {
      messages.push("No uppercase characters");
    }
    if (!hasNumbers) {
      messages.push("No numbers");
    }
    if (!hasSpecialChars) {
      messages.push("No special characters");
    }

    console.log(messages);
    this.password_message = messages.join(", ");
    console.log(this.password_message);
    this.correct_password = messages.length === 0;

    return this.correct_password;
  }

  password_repetition() {
    this.correctly_repeated = this.info.password !== this.info.repeated_password;
    return !this.correctly_repeated;
  }

  async email_validation() {
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    let emailExists = false;
    this.correct_email = !emailPattern.test(this.info.email);
    this.email_message = "Invalid email address!";
    console.log("emailPattern: " + this.correct_email);
    this.getUser(this.info.email).subscribe({
      next: (user) => {
        console.log('User retrieved:', user);
        if (user != null) {
          emailExists = true;
          this.email_message = "Such a user already exists!"
          this.correct_email = true;
          console.log("emailExists: " + this.correct_email);
        }
      }
    })
  }

  constructor(public globalService: GlobalService) {}

  async user_validation() {
    await this.email_validation();
    if (this.password_validation() && this.password_repetition() && !this.correct_email) {
      this.globalService.is_logged = true;
      const newUser: UserT = {
        username: this.info.username,
        email: this.info.email,
        photo: "",
        password: this.info.password
      };
      this.createUser(newUser);
      await this.router.navigate(['/main']);
    }
  }

  getUser(email: string): Observable<UserT> {
    return this.httpClient.get<UserT>(URL + "/users/" + email);
  }

  createUser(user: UserT) {
    const header = new HttpHeaders({'Content-Type': 'application/json'});
    console.log("createUser: " + user);
    this.httpClient.post(URL + "/users/", user, {headers: header}).subscribe(res => {
      console.log("POST: " + res);
    });
  }
}
