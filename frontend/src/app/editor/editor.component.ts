import {Component, inject} from '@angular/core';
import {TestHeadComponent} from './test-head/test-head.component';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {QuestionComponent} from "./question/question.component";
import {TestWithQuestions, TrueTest} from './test.model';
import {TestService} from '../services/test.service';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

const URL: string = 'http://localhost:8080';

@Component({
  selector: 'app-editor',
  standalone: true,
  imports: [
    TestHeadComponent,
    TopHeaderComponent,
    QuestionComponent
  ],
  templateUrl: './editor.component.html',
  styleUrl: './editor.component.css'
})

export class EditorComponent {
  constructor(private testService: TestService ) {}

  router = inject(Router);
  private httpClient = inject(HttpClient);

  data!: TestWithQuestions | null;
  oldTest!: TestWithQuestions | null;

  errorMessage: string = "";

  ngOnInit() {
    this.oldTest = JSON.parse(sessionStorage.getItem("test")!);
    this.testService.test$.subscribe((test) => {
      this.data = test;
      if (this.data) this.testService.logTestWithQuestions(this.data!);
    });
    this.data = JSON.parse(sessionStorage.getItem("test")!);
  }

  async onSaveTest() {
    console.log("EDITOR: ");

    if (this.data!.questions.length == 0) {
      console.log("Error: data can not be empty");

      this.errorMessage = "data can not be empty";
      return;
    }

    let allQuestionsHaveCorrectAnswers: boolean;

    // for (let i = 0; i < this.data!.questions.length; i++) {
    //   allQuestionsHaveCorrectAnswers = false;
    //   for (let j = 0; j < this.data!.questions[i].options.length; j++) { // option of every question
    //
    //     if (this.data!.questions[i].options[j].text.length == 0) {
    //       console.log("data can not be saved: options can not be empty");
    //       this.errorMessage = "data can not be saved: options can not be empty";
    //       return;
    //     }
    //
    //     if (this.data!.questions[i].options[j].correct) {
    //       allQuestionsHaveCorrectAnswers = true;
    //     }
    //
    //   }
    //
    //   if (!allQuestionsHaveCorrectAnswers) {
    //     console.log("data can not be saved: not all questions have correct answers.");
    //
    //     this.errorMessage = "data can not be saved: not all questions have correct answers.";
    //     return;
    //   }
    //
    //   if (this.data!.questions[i].text == null || this.data!.questions[i].text === "") {
    //     console.log("data can not be saved: questions can not be empty");
    //
    //     this.errorMessage = "data can not be saved: questions can not be empty";
    //     return;
    //   }
    // }
    await this.deleteTest(this.data?.id!);
    this.sendTest(this.data!);
    console.log("Going to main page");
    await this.router.navigate(['/main']);
  }

  onDeleteTest() {

    this.deleteTest(this.data?.id!);
    sessionStorage.removeItem("test");
    console.log("EDITOR: ");
    console.log("test id to remove set: " + this.data!.id);

    this.router.navigate(['/main']);
  }

  getTest(testId: string): Observable<TrueTest> {
    return this.httpClient.get<TrueTest>(URL + "/tests/" + sessionStorage.getItem("email") + "/" + testId);
  }

  async deleteTest(testId: string) {
    this.httpClient.delete<TrueTest>(URL + "/tests/" + testId).subscribe((d => {
    }));
  }

  sendTest(test: TestWithQuestions) {
    console.log("UPDATE MAPPING");
    this.httpClient.post<TestWithQuestions>(URL + "/tests/", test).subscribe((d => {
    }));
  }

}
