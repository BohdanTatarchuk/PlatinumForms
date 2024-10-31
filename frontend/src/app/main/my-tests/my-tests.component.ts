import {Component, inject} from '@angular/core';
import {MyTestComponent} from './my-test/my-test.component';
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

  tests: any;

  router = inject(Router);

  ngOnInit() {
    this.tests = this.globalService.tests;

    const testIdToRemove = this.testService.getTestId();
    if (testIdToRemove) {
      console.log("-------------------MAIN---------------------");
      console.log("Test id to remove got: " + testIdToRemove);
      this.globalService.tests = this.globalService.tests!.filter((item: Test) => item.id !== testIdToRemove);
      this.tests = this.globalService.tests;

      for (let i = 0; i < this.tests.length; i++) {
        console.log(this.tests[i].name + ", ");
      }
    }
  }

  onSelectTest(id: string): void {
    console.log("Selected test with id " + id);
  }

  onSelectNewTest(): void {
    let emptyTest: Test = {
      name: "empty test",
      id: this.testService.generateQID(),
      description: "",
      questions: []
    }

    this.globalService.tests!.push(emptyTest);

    console.log("---------------MAIN-----------------\n" +
      "Test sent: "
      + emptyTest.name + ", "
      + emptyTest.description + ", "
      + emptyTest.id);

    this.testService.setTest(emptyTest);
    this.router.navigate(['/editor']);
  }
}
