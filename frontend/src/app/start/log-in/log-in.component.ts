import {Component, inject} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Router, RouterOutlet} from '@angular/router';
import {GlobalService} from '../../services/global.service';

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

  constructor(public globalService: GlobalService) {}

  user = {
    email: '',
    password: ''
  }

  navigateToMain() {
    this.router.navigate(['/main']);
    this.globalService.is_logged = true;
  }

  navigateToRegistration() {
    this.router.navigate(['/registration']);
  }
}
