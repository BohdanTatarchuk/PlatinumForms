import {Component, inject} from '@angular/core';
import {TestHeadComponent} from './test-head/test-head.component';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {QuestionComponent} from "./question/question.component";
import {Test} from './test.model';
import {TestService} from '../services/test.service';
import {Router} from '@angular/router';
import {last} from 'rxjs';

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
    let allQuestionsHaveCorrectAnswers: boolean = false;

    for (let i = 0; i < this.test.questions.length; i++) {
      allQuestionsHaveCorrectAnswers = false;
      for (let j = 0; j < this.test.questions[i].options.length; j++) {
        if (this.test.questions[i].options[j].correct) {
          allQuestionsHaveCorrectAnswers = true;
          break;
        }
      }
      if (!allQuestionsHaveCorrectAnswers) {
        console.log("EDITOR: ");
        console.log("Test can not be saved: not all questions have correct answers.");

        this.errorMessage = "Test can not be saved: not all questions have correct answers.";
        return;
      }
    }

    this.router.navigate(['/main']);
  }

  onDeleteTest() {
    this.testService.setTestId(this.test.id);

    console.log("EDITOR: ");
    console.log("Test id to remove set: " + this.test.id);

    this.router.navigate(['/main']);
  }
}
