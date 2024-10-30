import {Component, inject} from '@angular/core';
import {Router} from '@angular/router';
import {GlobalService} from '../../services/global.service';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {


  constructor(public globalSercive: GlobalService) {}

  imageUrl: string = "";

  router = inject(Router)

  ngOnInit(){
    this.imageUrl = this.globalSercive.photo;
  }

  navigate_to_profile(){
    this.router.navigate(['/profile'])
  }
}
