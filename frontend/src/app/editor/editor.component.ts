import {Component, inject} from '@angular/core';
import {TestHeadComponent} from './test-head/test-head.component';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {QuestionComponent} from "./question/question.component";
import {TestWithQuestions} from './test.model';
import {TestService} from '../services/test.service';
import {Router} from '@angular/router';
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
  constructor(private testService: TestService) {}

  router = inject(Router);
  private httpClient = inject(HttpClient);

  data!: TestWithQuestions | null;
  errorMessage: string = "";

  ngOnInit() {
    this.data = JSON.parse(sessionStorage.getItem("test")!);
    this.testService.test$.subscribe((test) => {

      if (!test) {
        console.error("EDITOR: OnInit test is null");
        return;
      }
      this.data = test;
      this.testService.logTestWithQuestions(this.data!);
    });
  }

  async onSaveTest() {
    if (!this.data) {
      console.error("EDITOR: Data is null or undefined.");
      this.errorMessage = "No test data available.";
      return;
    }

    for (let i = 0; i < this.data.questions.length; i++) {
      const questionHasCorrectAnswer = this.data.questions[i].options.some(option => option.correct);
      let isObligatory = this.data.questions[i].obligatory;
      if (!questionHasCorrectAnswer) {
        console.log(`Test cannot be saved: Question ${i + 1} does not have any correct options.`);
        this.errorMessage = `Test cannot be saved: Question ${i + 1} does not have any correct options.`;
        return;
      }

      const optionWithEmptyText = this.data.questions[i].options.some(option => !option.text);
      if (optionWithEmptyText) {
        console.log(`Test cannot be saved: Options for question ${i + 1} cannot be empty.`);
        this.errorMessage = `Test cannot be saved: Options for question ${i + 1} cannot be empty.`;
        return;
      }

      if (!this.data.questions[i].text || !this.data.questions[i].text.trim()) {
        console.log(`Test cannot be saved: Question ${i + 1} text cannot be empty.`);
        this.errorMessage = `Test cannot be saved: Question ${i + 1} text cannot be empty.`;
        return;
      }
    }

    try {
      await this.deleteTest(this.data.id);
      await this.sendTest({...this.data});
      console.log("Navigating to main page...");
      await this.router.navigate(['/main']);
    } catch (error) {
      console.error("Error during save operation:", error);
      this.errorMessage = "Failed to save test data.";
    }
  }

  onDeleteTest() {
    this.deleteTest(this.data?.id!);
    sessionStorage.removeItem("test");
    console.log("EDITOR: ");
    console.log("test id to remove set: " + this.data!.id);

    this.router.navigate(['/main']);
  }

  async deleteTest(testId: string): Promise<void> {
    try {
      await this.httpClient.delete(`${URL}/tests/${testId}`).toPromise();
      console.log("Test deleted successfully.");
    } catch (error) {
      console.error("Error deleting test:", error);
    }
  }

  async sendTest(test: {}): Promise<void> {
    try {
      await this.httpClient.post<TestWithQuestions>(`${URL}/tests/`, test).toPromise();
      console.log("Test sent successfully.");
    } catch (error) {
      console.error("Error sending test:", error);
    }
  }
}
