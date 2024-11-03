import {Component} from '@angular/core';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {TestHeadComponent} from './test-head/test-head.component';
import {TestService} from '../services/test.service';
import {Test} from '../editor/test.model';
import {TestQuestionComponent} from './test-question/test-question.component';
import {Question} from '../editor/question/question.model';
import {CommonModule} from '@angular/common';
import {Subject} from 'rxjs';

@Component({
  selector: 'app-test-page',
  standalone: true,
  imports: [
    TopHeaderComponent,
    TestHeadComponent,
    TestQuestionComponent,
    CommonModule
  ],
  templateUrl: './test-page.component.html',
  styleUrl: './test-page.component.css'
})
export class TestPageComponent {

  saveTrigger = new Subject<void>();

  constructor(private testService: TestService) {
  }

  test!: Test;
  obligatory_message: string = "●All obligatory questions must be answered!";
  overallMark: number = 0;
  checked: boolean = true;

  ngOnInit() {
    this.test = this.testService.getTest();
  }

  onSave() {

    this.test = this.testService.getTest();

    if (!this.obligatoryCheck()) {
      this.checked = false;
      return;
    }

    for (let i = 0; i < this.test.questions.length; i++) {

      if (this.test.questions[i].type === 0) {
        this.test.questions[i].mark = this.calculateSingleChoice(this.test.questions[i]);
        this.overallMark += this.calculateSingleChoice(this.test.questions[i]);
      } else if (this.test.questions[i].type === 1) {
        this.test.questions[i].mark = this.calculateMultipleChoice(this.test.questions[i]);
        this.overallMark += this.calculateMultipleChoice(this.test.questions[i]);
      } else {
        this.test.questions[i].mark = this.calculateFreeAnswer(this.test.questions[i]);
        this.overallMark += this.calculateFreeAnswer(this.test.questions[i]);
      }
    }

    console.log("Overall mark: " + this.overallMark);

    this.saveTrigger.next();
  }

  obligatoryCheck(): boolean {
    for (let i = 0; i < this.test.questions.length; i++) {
      if (this.test.questions[i].obligatory && this.test.questions[i].answered.length === 0) {
        return false;
      }
    }
    return true;
  }

  calculateMultipleChoice(question: Question): number {
    let numberOfCorrectAnswers: number = 0;
    let numberOfIncorrectAnswers: number = 0;

    let numberOfSolutions: number = 0;

    for (let i = 0; i < question.options.length; i++) {
      if (question.options[i].correct) ++numberOfSolutions;
    }

    let pointsPerCorrectAnswer = +(1 / numberOfSolutions).toFixed(2);

    for (let i = 0; i < question.answered.length; i++) {
      if (question.options.find(item => item.id === question.answered[i])?.correct) {
        numberOfCorrectAnswers++;
      } else {
        ++numberOfIncorrectAnswers;
      }
    }

    let mark = (numberOfCorrectAnswers - numberOfIncorrectAnswers) * pointsPerCorrectAnswer;
    if (mark < 0) mark = 0;
    return mark;
  }

  calculateFreeAnswer(question: Question): number {
    if (question.options.find(item => item.name.trim() === question.answered[0].trim())) {
      console.log("Question: " + question.name + "has mark 1");
      return 1
    }
    console.log("Question: " + question.name + "has mark 0");
    return 0;
  }

  calculateSingleChoice(question: Question): number {
    if (question.options.find(answer => answer.id === question.answered[0])?.correct) {
      console.log("Question: " + question.name + "has mark 1");
      return 1;
    }
    console.log("Question: " + question.name + "has mark 0");
    return 0;
  }
}
