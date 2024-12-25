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
  constructor(private testService: TestService) {
  }

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

    // TODO
    // for (let i = 0; i < this.data.questions.length; i++) {
    //   let allQuestionsHaveCorrectAnswers = false;
    //   for (let j = 0; j < this.data.questions[i].options.length; j++) {
    //     // Check if any option has empty text
    //     if (!this.data.questions[i].options[j].text) {
    //       console.log("Test cannot be saved: options cannot be empty");
    //       this.errorMessage = "Test cannot be saved: options cannot be empty";
    //       return;
    //     }
    //
    //     // At least one correct option is required
    //     if (this.data.questions[i].options[j].correct) {
    //       allQuestionsHaveCorrectAnswers = true;
    //     }
    //   }
    //
    //   // If no correct option exists for the question
    //   if (allQuestionsHaveCorrectAnswers) {
    //     console.log("Test cannot be saved: not all questions have correct answers.");
    //     this.errorMessage = "Test cannot be saved: not all questions have correct answers.";
    //     return;
    //   }
    //
    //   // Check if question text is empty or null
    //   if (!this.data.questions[i].text) {
    //     console.log("Test cannot be saved: questions cannot be empty");
    //     this.errorMessage = "Test cannot be saved: questions cannot be empty";
    //     return;
    //   }
    // }

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
