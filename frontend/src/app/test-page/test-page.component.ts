import {Component} from '@angular/core';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {TestHeadComponent} from './test-head/test-head.component';
import {TestService} from '../services/test.service';
import {Test} from '../editor/test.model';
import {TestQuestionComponent} from './test-question/test-question.component';
import {Question} from '../editor/question/question.model';
import * as test from 'node:test';

@Component({
  selector: 'app-test-page',
  standalone: true,
  imports: [
    TopHeaderComponent,
    TestHeadComponent,
    TestQuestionComponent,
  ],
  templateUrl: './test-page.component.html',
  styleUrl: './test-page.component.css'
})
export class TestPageComponent {
  constructor(private testService: TestService) {
  }

  test!: Test;
  obligatory_message: string = "●All obligatory questions must be answered!";

  ngOnInit() {
    this.test = this.testService.getTest();
  }

  onSave() {
    this.test = this.testService.getTest();

    if (!this.obligatoryCheck()) {
      return;
    }

    let overallMark: number = 0;

    for (let i = 0; i < this.test.questions.length; i++) {
      overallMark += this.calculateQuestion(this.test.questions[i]);
    }

    /*console.log("--------------------------TEST-------------------------------");
    for (let i = 0; i < this.test.questions.length; i++) {
      console.log("Question " + i + ": ");
      for (let j = 0; j < this.test.questions[i].answered.length; j++) {
        console.log(this.test.questions[i].answered[j] + ", ");
      }
    }*/
  }

  obligatoryCheck(): boolean {
    for (let i = 0; i < this.test.questions.length; i++) {
      if (this.test.questions[i].obligatory && this.test.questions[i].answered.length === 0) {
        return false;
      }
    }
    return true;
  }

  calculateQuestion(question: Question): number {
    let numberOfAnswers: number = question.answered.length;
    let numberOfOptions: number = question.options.length;
    let pointsPerAnswer: number = +(1 / numberOfOptions).toFixed(2);

    let mark: number = 0;

    //not obligatory questions are not included in overall mark
    if (!question.obligatory) {
      return 0;
    }

    //if user has not given an answer
    if (numberOfAnswers === 0 && question.obligatory) {
      return 0;
    }

    for (let i = 0; i < numberOfOptions; i++) {
      for (let j = 0; j < numberOfAnswers; j++) {
        if (question.options[i].id === question.answered[j]) {
          mark += pointsPerAnswer;
        }
      }
    }


    return 1;
  }
}
