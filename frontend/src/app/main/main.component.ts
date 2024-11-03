import { Component } from '@angular/core';
import {JoinTestComponent} from './join-test/join-test.component';
import {MyTestComponent} from './my-tests/my-test/my-test.component';
import {MyTestsComponent} from './my-tests/my-tests.component';
import {ProfileComponent} from './profile/profile.component';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {DUMMY_TESTS} from './my-tests/my-test/dummy-data';

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [
    JoinTestComponent,
    MyTestComponent,
    MyTestsComponent,
    ProfileComponent,
    TopHeaderComponent
  ],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {

  ngOnInit(){
    console.log(DUMMY_TESTS[0].tests[0].mark);
  }
}
