import {Component} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Test} from '../test.model';
import {TestService} from '../../services/TestService';
import { Question} from '../question/question.model';

@Component({
  selector: 'app-test-head',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './test-head.component.html',
  styleUrl: './test-head.component.css'
})

export class TestHeadComponent {
  constructor(private testService: TestService ) {}

  test!: Test;

  ngOnInit() {
    this.test = this.testService.getTest();

    console.log(
      "Received test in TestHeadComponent with the following data: "
      + this.test.id + ", "
      + this.test.name + ", "
      + this.test.description + ", "
      + this.test.code
    );
  }

  emptyQuestion: Question = {
    name : "Question",
    id : "3j4h9zfdiuvs",
    obligatory : true,
    type : 1
  }

  onAddQuestion() {
    this.test.questions.push(this.emptyQuestion);
  }
}
