import {Component} from '@angular/core';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {GlobalService} from '../services/global.service';
import {DUMMY_TESTS} from '../main/my-tests/my-test/dummy-data';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [
    TopHeaderComponent
  ],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {
  constructor(public globalSercive: GlobalService) {}

  imageUrl: string = "";
  username: string | undefined ;
  email: string = "";

  ngOnInit(){
    this.email = this.globalSercive.email;
    this.username = this.globalSercive.username;
    this.imageUrl = this.globalSercive.photo;
  }

  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];
      const reader = new FileReader();
      reader.onload = (e: any) => {
        this.imageUrl = this.globalSercive.photo;
        this.imageUrl = e.target.result;
        this.globalSercive.photo = this.imageUrl;
      };
      reader.readAsDataURL(file);
    }
  }
}
