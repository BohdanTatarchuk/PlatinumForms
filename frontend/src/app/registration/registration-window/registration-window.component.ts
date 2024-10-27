import {Component, inject} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Router} from '@angular/router';
import {GlobalService} from '../../services/global.service';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-registration-window',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule
  ],
  templateUrl: './registration-window.component.html',
  styleUrl: './registration-window.component.css'
})
export class RegistrationWindowComponent {

  router = inject(Router)

  info = {
    email: '',
    username: '',
    password: '',
    repeated_password: ''
  }
  public correct_email: boolean = false;
  public correct_password: boolean = false;
  public correctly_repeated: boolean = false;
  public email_message: string = "● Nonexistent email";
  public password_message: string = "";
  public repeated_password_message: string = "● Passwords do not match";

  password_validation() {
    let hasLowerChars = false;
    let hasUpperChars = false;
    let hasSpecialChars = false;
    let hasNumbers = false;

    for (let i = 0; i < this.info.password.length; i++) {
      const char = this.info.password.charAt(i);

      if (/[a-z]/.test(char)) hasLowerChars = true;
      if (/[A-Z]/.test(char)) hasUpperChars = true;
      if (/[0-9]/.test(char)) hasNumbers = true;
      if (/[^a-zA-Z0-9]/.test(char)) hasSpecialChars = true;
    }

    if (hasLowerChars && hasUpperChars && hasNumbers && hasSpecialChars) {
      this.correct_password = false;
      return true;
    }
    this.correct_password = true;
    if (!hasLowerChars) {
      this.password_message = "● No lowercase characters"
    }
    if (!hasUpperChars) {
      this.password_message = "● No uppercase characters"
    }
    if (!hasNumbers) {
      this.password_message = "● No numbers"
    }
    if (!hasSpecialChars) {
      this.password_message = "● No special characters"
    }
    return false;
  }

  password_repetition() {
    if (this.info.password != this.info.repeated_password) {
      this.correctly_repeated = true;
      return false;
    }
    this.correctly_repeated = false
    return true;
  }

  email_validation() {
    let emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._%+-]+\.[a-zA-Z0-9._%+-]/;
    if (!emailPattern.test(this.info.email)) {
      this.correct_email = true;
      return false;
    }
    this.correct_email = false;
    return true;
  }

  navigate_to_main() {
    this.router.navigate(['/main']);
  }

  constructor(public globalService: GlobalService) {
  }

  user_validation() {
    if (this.email_validation() && this.password_validation() && this.password_repetition()) {
      this.globalService.is_logged = true;
    }
    console.log(this.globalService.is_logged)
    if (this.globalService.is_logged) {
      this.navigate_to_main();
    }
  }
}
