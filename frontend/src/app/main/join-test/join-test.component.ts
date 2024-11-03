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
    let info = this.users.find(user => user.tests.find(test => test.id == this.code));
    let actual_info = info?.tests.find(test => test.id == this.code);
    console.log(actual_info);
    if (actual_info) {
      actual_info.mark = null;
      for (let i = 0; i < actual_info.questions.length; i++) {
        actual_info.questions[i].answered.length = 0;
      }
      this.testService.setTest(actual_info);
      this.router.navigate(['/test-page']);
    }
  }
}
