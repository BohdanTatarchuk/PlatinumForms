import {Component, inject} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Router, RouterOutlet} from '@angular/router';
import {GlobalService} from '../../services/global.service';
import {User} from '../../registration/registration-window/user.model';
import {FAKE_DATA} from '../../registration/registration-window/fake-data';

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

  users = FAKE_DATA;

  data_check() {
    const info = this.users.find(user => user.email == this.data.email)
    if (info?.email == this.data.email && info?.password == this.data.password) {
      this.globalService.is_logged = true;
      this.globalService.email = this.data.email;
      this.router.navigate(['/main']);
    }else console.log("AAAAAAAAAA")
  }

  navigateToRegistration() {
    this.router.navigate(['/registration']);
  }
}
