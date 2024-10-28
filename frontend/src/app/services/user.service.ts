import { Injectable } from '@angular/core';
import {User} from '../registration/registration-window/user.model';

@Injectable({
  providedIn: 'root'
})

export class UserService {
  private user!: User;

  setUser(user: User) {
    this.user = user;
  }

  getUser() {
    return this.user;
  }
}
