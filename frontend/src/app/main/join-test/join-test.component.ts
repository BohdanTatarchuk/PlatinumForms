import { Component } from '@angular/core';
import {MyTestComponent} from '../my-tests/my-test/my-test.component';

@Component({
  selector: 'app-join-test',
  standalone: true,
  imports: [
    MyTestComponent
  ],
  templateUrl: './join-test.component.html',
  styleUrl: './join-test.component.css'
})

export class JoinTestComponent {

}
