import {Component, inject} from '@angular/core';
import {MyTestComponent} from '../my-tests/my-test/my-test.component';
import {FormsModule} from "@angular/forms";
import {Router} from '@angular/router';
import {DUMMY_TESTS} from '../my-tests/my-test/dummy-data';
import {TestService} from '../../services/test.service';
import {Test} from '../../editor/test.model';

@Component({
  selector: 'app-join-test',
  standalone: true,
  imports: [
    MyTestComponent,
    FormsModule
  ],
  templateUrl: './join-test.component.html',
  styleUrl: './join-test.component.css'
})

export class JoinTestComponent {

  constructor(private testService: TestService ) {}

  router = inject(Router)

  code: string = '';
  users = DUMMY_TESTS;
  test!: Test;

  joinTest() {
    const info = this.users.find(user => user.tests.find(test => test.id == this.code));
    const actual_info = info?.tests.find(test => test.id == this.code);
    console.log(actual_info);
    if(actual_info){
      this.testService.setTest(actual_info);
      this.router.navigate(['/test-page']);
    }
  }

}
