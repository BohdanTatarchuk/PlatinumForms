import { Component } from '@angular/core';
import {TestHeadComponent} from './test-head/test-head.component';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {QuestionComponent} from "./question/question.component";
import {TestService} from '../services/TestService';
import {Test} from './test.model';

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

  test!: Test;

  ngOnInit() {
    this.test = this.testService.getTest();

    console.log(
      "Received test in EditorComponent with the following data: "
      + this.test.id + ", "
      + this.test.name + ", "
      + this.test.description + ", "
      + this.test.code
    );

  }
}
