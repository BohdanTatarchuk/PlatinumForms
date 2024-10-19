import {Component} from '@angular/core';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-log-in',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './log-in.component.html',
  styleUrl: './log-in.component.css'
})
export class LogInComponent {
  user = {
    email: '',
    password: ''
  }

  onSubmit() {
    console.log('Email:', this.user.email);
    console.log('Password:', this.user.password);
  }
}
