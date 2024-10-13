import { Component } from '@angular/core';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {LogInComponent} from './log-in/log-in.component';

@Component({
  selector: 'app-start',
  standalone: true,
  imports: [
    TopHeaderComponent,
    LogInComponent
  ],
  templateUrl: './start.component.html',
  styleUrl: './start.component.css'
})
export class StartComponent {

}
