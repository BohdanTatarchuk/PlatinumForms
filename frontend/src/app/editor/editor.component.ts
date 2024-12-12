import {Component, inject} from '@angular/core';
import {TestHeadComponent} from './test-head/test-head.component';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {QuestionComponent} from "./question/question.component";
import {Test} from './test.model';
import {TestService} from '../services/test.service';
import {Router} from '@angular/router';
import {Question} from './question/question.model';

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

  test!: Test;

  errorMessage: string = "";

  ngOnInit() {
    this.test = this.testService.getTest();
  }

  onSaveTest() {
    console.log("EDITOR: ");

    for (let i = 0; i < this.test.questions.length; i++) {
      this.outputQuestion(this.test.questions[i]);
    }


    if (this.test.questions.length == 0) {
      console.log("Error: test can not be empty");

      this.errorMessage = "Test can not be empty";
      return;
    }

    let allQuestionsHaveCorrectAnswers: boolean = false;

    for (let i = 0; i < this.test.questions.length; i++) {
      allQuestionsHaveCorrectAnswers = false;
      for (let j = 0; j < this.test.questions[i].options.length; j++) {

        if (this.test.questions[i].options[j].name.length == 0) {
          console.log("Test can not be saved: options can not be empty");
          this.errorMessage = "Test can not be saved: options can not be empty";
          return;
        }

        if (this.test.questions[i].options[j].correct) {
          allQuestionsHaveCorrectAnswers = true;
        }

      }

      if (!allQuestionsHaveCorrectAnswers) {
        console.log("Test can not be saved: not all questions have correct answers.");

        this.errorMessage = "Test can not be saved: not all questions have correct answers.";
        return;
      }

      if (this.test.questions[i].name == null || this.test.questions[i].name === "") {
        console.log("Test can not be saved: questions can not be empty");

        this.errorMessage = "Test can not be saved: questions can not be empty";
        return;
      }
    }

    console.log("Going to main page");
    this.router.navigate(['/main']);
  }

  onDeleteTest() {
    this.testService.setTestId(this.test.id);

    console.log("EDITOR: ");
    console.log("Test id to remove set: " + this.test.id);

    this.router.navigate(['/main']);
  }

  outputQuestion(question: Question) {
    console.log("Question: " + question.name + "\n" +
    "Id: " + question.id + "\n" +
    "Options: " + JSON.stringify(question.options));
  }
}
