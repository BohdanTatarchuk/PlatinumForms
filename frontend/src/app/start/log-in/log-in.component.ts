import {Component, inject} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Router, RouterOutlet} from '@angular/router';

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

  user = {
    email: '',
    password: ''
  }

  onSubmit() {
    console.log('Email:', this.user.email);
    console.log('Password:', this.user.password);
  }

  protected readonly navigator = navigator;

  navigateToMain() {
    this.router.navigate(['/main']);
  }

  navigateToRegistration() {
    this.router.navigate(['/registration']);
  }
}
