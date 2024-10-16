import { Component } from '@angular/core';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {SingleChoiceQuestionComponent} from './single-choice-question/single-choice-question.component';
import {MultipleChoiceQuestionComponent} from './multiple-choice-question/multiple-choice-question.component';
import {FreeAnswerQuestionComponent} from './free-answer-question/free-answer-question.component';
import {TestHeadComponent} from '../test-head/test-head.component';

@Component({
  selector: 'app-test-page',
  standalone: true,
  imports: [
    TopHeaderComponent,
    SingleChoiceQuestionComponent,
    MultipleChoiceQuestionComponent,
    FreeAnswerQuestionComponent,
    TestHeadComponent
  ],
  templateUrl: './test-page.component.html',
  styleUrl: './test-page.component.css'
})
export class TestPageComponent {

}
