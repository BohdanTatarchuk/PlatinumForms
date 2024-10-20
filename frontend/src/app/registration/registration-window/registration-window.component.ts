import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';

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

  info = {
    email:'',
    username:'',
    password:'',
    repeated_password:''
  }

  onSubmit() {
    console.log('Email:', this.info.email);
    console.log('Username:', this.info.username);
    console.log('Password:', this.info.password);
    console.log('Repeated password:', this.info.repeated_password);
  }
}
