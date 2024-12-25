import {Component, inject} from '@angular/core';
import {MyTestComponent} from './my-test/my-test.component';
import {Router} from '@angular/router';
import {Test, TestWithQuestions, TrueTest} from '../../editor/test.model';
import {GlobalService} from '../../services/global.service';
import {TestService} from '../../services/test.service';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserT} from '../../registration/registration-window/user.model';
import {QuestionWithOptions} from '../../editor/question/question.model';

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
  constructor(public testService: TestService) {}

  tests: TrueTest[] | undefined;
  author!: UserT;

  private httpClient = inject(HttpClient);
  router = inject(Router);

  errorMaxAmount: string = "";

  async ngOnInit() {
    (await this.getTests()).subscribe({
      next: (tests) => {
        console.log('MAIN: Tests retrieved:', tests);
        this.tests = tests;
      }
    });

    (await this.getAuthor()).subscribe({
      next: (user) => {
        console.log('MAIN: User retrieved:', user);
        this.author = user;
      }
    })
  }

  onSelectNewTest(): void {
    if (this.tests!.length >= MAX_AMOUNT_OF_TESTS) {
      console.log("Max amount of tests of " + MAX_AMOUNT_OF_TESTS + " surpassed");
      this.errorMaxAmount = "Max amount of tests surpassed";
      return;
    } else {
      this.errorMaxAmount = "";
    }

    let emptyTest: TestWithQuestions = {
      name: "Empty test",
      description: "",
      id: this.testService.generateQID(),
      authorEmail: this.author,
      questions: []
    }

    sessionStorage.setItem("test", JSON.stringify(emptyTest));
    this.router.navigate(['/editor']);
  }

  async getTests(): Promise<Observable<TrueTest[]>> {
    return this.httpClient.get<TrueTest[]>(URL + "/tests/" + sessionStorage.getItem("email"));
  }

  async getAuthor(): Promise<Observable<UserT>> {
    return this.httpClient.get<UserT>(URL + "/users/" + sessionStorage.getItem("email"));
  }
}
