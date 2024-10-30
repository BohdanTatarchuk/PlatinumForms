import {Component, inject} from '@angular/core';
import {MyTestComponent} from './my-test/my-test.component';
import { DUMMY_TESTS } from './my-test/dummy-data';
import {Router} from '@angular/router';
import {Test} from '../../editor/test.model';
import {GlobalService} from '../../services/global.service';
import {TestService} from '../../services/test.service';

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
  constructor(public globalService: GlobalService, public testService: TestService) {}

  data = DUMMY_TESTS;
  tests: any;

  receivedTestId!: string;

  router = inject(Router);

  ngOnInit() {
    const user = this.data.find(user => user.email === this.globalService.email)
    this.tests = user!.tests;

    this.receivedTestId = this.testService.getTestId();
    if (!this.receivedTestId == null) {
      user?.tests.filter(test => test.id !== this.receivedTestId);
    }
  }

  onSelectTest(id: string): void {
    console.log("Selected test with id " + id);
  }

  onSelectNewTest(): void {
    this.router.navigate(['/editor']);
  }
}
