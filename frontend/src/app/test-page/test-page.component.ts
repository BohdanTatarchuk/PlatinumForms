import { Component } from '@angular/core';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {TestHeadComponent} from './test-head/test-head.component';
import {TestService} from '../services/test.service';
import {Test} from '../editor/test.model';
import {TestQuestionComponent} from './test-question/test-question.component';

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
  constructor(private testService: TestService ) {}

  test!: Test;

  ngOnInit() {
    this.test = this.testService.getTest();
  }

  onSave() {

  }
}
