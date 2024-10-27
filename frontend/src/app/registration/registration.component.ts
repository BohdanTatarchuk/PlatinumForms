import { Component } from '@angular/core';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {RegistrationWindowComponent} from './registration-window/registration-window.component';

@Component({
  selector: 'app-registration',
  standalone: true,
  imports: [
    TopHeaderComponent,
    RegistrationWindowComponent
  ],
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})

export class RegistrationComponent {

}
