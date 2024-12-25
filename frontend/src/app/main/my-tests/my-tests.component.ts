import {Component, inject} from '@angular/core';
import {MyTestComponent} from './my-test/my-test.component';
import {Router} from '@angular/router';
import {Test, TrueTest} from '../../editor/test.model';
import {GlobalService} from '../../services/global.service';
import {TestService} from '../../services/test.service';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

const MAX_AMOUNT_OF_TESTS = 10;
const URL: string = 'http://localhost:8080';

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

  tests: TrueTest[] | undefined;

  private httpClient = inject(HttpClient);
  router = inject(Router);

  errorMaxAmount: string = "";

  async ngOnInit() {
    (await this.getTests()).subscribe({
      next: (tests) => {
        console.log('Tests retrieved:', tests);
        this.tests = tests;
      }
    });
  }

  onSelectNewTest(): void {
    if (this.globalService.tests!.length >= MAX_AMOUNT_OF_TESTS) {
      console.log("Max amount of tests of " + MAX_AMOUNT_OF_TESTS + " surpassed");
      this.errorMaxAmount = "Max amount of tests surpassed";
      return;
    } else {
      this.errorMaxAmount = "";
    }

    let emptyTest: Test = {
      name: "empty test",
      id: this.testService.generateQID(),
      description: "",
      mark: null,
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

  async getTests(): Promise<Observable<TrueTest[]>> {
    return this.httpClient.get<TrueTest[]>(URL + "/tests/" + sessionStorage.getItem("email"));
  }
}
