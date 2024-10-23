import {Component, inject} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-registration-window',
  standalone: true,
  imports: [
    FormsModule
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
      console.log("Password saved");
      return true;
    }

    if (!hasLowerChars) {
      console.log("No lowercase characters");
    }
    if (!hasUpperChars) {
      console.log("No uppercase characters");
    }
    if (!hasNumbers) {
      console.log("No numbers");
    }
    if (!hasSpecialChars) {
      console.log("No special characters");
    }

    return false;
  }

  password_repetition() {
    if (this.info.password != this.info.repeated_password) {
      console.log("Mistake in repeated password");
    }
  }

  email_validation() {
    let emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._%+-]+\.[a-zA-Z0-9._%+-]/;
    if (!emailPattern.test(this.info.email)) {
      console.log("Wrong email!")
    }
  }

  onSubmit() {
    console.log('Email:', this.info.email);
    console.log('Username:', this.info.username);
    console.log('Password:', this.info.password);
    console.log('Repeated password:', this.info.repeated_password);
  }

  navigate_to_main() {
    this.router.navigate(['/main']);
  }

}
