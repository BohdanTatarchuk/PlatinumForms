import {Component, inject} from '@angular/core';
import {Router} from '@angular/router';
import {GlobalService} from '../../services/global.service';
import {User} from '../../registration/registration-window/user.model';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {
  constructor(public globalSercive: GlobalService) {}

  username: string = "";
  email: string = "";
  imageUrl: string = "";

  router = inject(Router)

  ngOnInit(){
    this.imageUrl = this.globalSercive.photo;
    this.username = this.globalSercive.username;
    this.email = this.globalSercive.email;
  }

  navigate_to_profile(){
    this.router.navigate(['/profile'])
  }
}
