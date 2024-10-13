import { Component } from '@angular/core';
import {MyTestComponent} from './my-test/my-test.component';

@Component({
  selector: 'app-my-tests',
  standalone: true,
  imports: [
    MyTestComponent
  ],
  templateUrl: './my-tests.component.html',
  styleUrl: './my-tests.component.css'
})
export class MyTestsComponent {

}
