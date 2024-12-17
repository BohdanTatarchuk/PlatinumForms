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

  username: string | null = "";
  email: string | null = "";
  imageUrl: string | null = "";

  router = inject(Router)

  ngOnInit(){
    this.imageUrl = sessionStorage.getItem("photo");
    this.username = sessionStorage.getItem("username");
    this.email = sessionStorage.getItem("email");
  }

  navigate_to_profile(){
    this.router.navigate(['/profile'])
  }
}
