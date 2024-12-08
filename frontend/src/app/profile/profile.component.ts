import {Component, inject} from '@angular/core';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {GlobalService} from '../services/global.service';
import {DUMMY_TESTS} from '../main/my-tests/my-test/dummy-data';
import {Router} from '@angular/router';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [
    TopHeaderComponent,
    FormsModule
  ],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {
  constructor(public globalService: GlobalService) {}

  router = inject(Router)

  imageUrl: string = "";
  username: string | undefined ;
  email: string = "";

  newUsername: string = "";
  emptyError: string = "";

  ngOnInit(){
    this.email = this.globalService.email;
    this.username = this.globalService.username;
    this.imageUrl = this.globalService.photo;
  }

  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];
      const reader = new FileReader();
      reader.onload = (e: any) => {
        this.imageUrl = this.globalService.photo;
        this.imageUrl = e.target.result;
        this.globalService.photo = this.imageUrl;
      };
      reader.readAsDataURL(file);
    }
  }

  logout() {
    this.globalService.email = "";
    this.globalService.photo = "";
    this.globalService.username = "";
    this.globalService.is_logged = false;
    this.router.navigate(['/']);
  }

  changeUsername() {
    if (this.newUsername) {
      this.globalService.username = this.newUsername;
      this.username = this.newUsername;
      this.emptyError = "";
    } else {
      this.emptyError = "Username can not be empty";
    }
  }
}
