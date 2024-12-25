import {Component, EventEmitter, Output} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {TestService} from '../../services/test.service';
import {TestWithQuestions} from '../test.model';

const MAX_NUMBER_OF_QUESTIONS: number = 50;

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
  constructor(private testService: TestService) {}

  test!: TestWithQuestions;
  maxNumberOfQuestionsError: string = "";

  @Output() buttonClick = new EventEmitter<any>();

  ngOnInit() {
    this.testService.test$.subscribe((test) => {
      this.test = test!;
    });
    this.test = JSON.parse(sessionStorage.getItem("test")!);

    console.log("Received tests in TestHeadComponent with the following data: ");
    this.testService.logTestWithQuestions(this.test!);
  }

  onAddQuestion(): void {
    if (this.test.id == undefined) {
      return;
    }
    const newQuestion = {
      text: "",
      id: this.testService.generateQID(),
      obligatory: false,
      options: [],
      test_id: this.test.id,
      type: 0,
      test: {
        name: this.test!.name,
        description: this.test!.description,
        id: this.test!.id,
        authorEmail: this.test!.authorEmail
      }
    }

    if (this.test.questions.length < MAX_NUMBER_OF_QUESTIONS) {
      this.test.questions.push(newQuestion);
      console.log("New question with id " + newQuestion.id + " added");
    } else {
      console.log("New question can not be added: limit of questions is " + MAX_NUMBER_OF_QUESTIONS);
      this.maxNumberOfQuestionsError = "Maximal number of questions is " + MAX_NUMBER_OF_QUESTIONS;
    }
    this.testService.logTestWithQuestions(this.test);
    this.testService.updateTest(this.test);
  }
}
