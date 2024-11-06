import {Component} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {TestService} from '../../services/test.service';
import {Test} from '../test.model';

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

  test!: Test;
  maxNumberOfQuestionsError: string = "";

  ngOnInit() {
    this.test = this.testService.getTest();

    console.log(
      "Received tests in TestHeadComponent with the following data: "
      + this.test.id + ", "
      + this.test.name
    );
  }

  onAddQuestion(): void {
    const newQuestion = {
      name: '',
      id: '',
      obligatory: false,
      type: 0,
      mark: 0,
      options: [],
      answered: []
    }

    newQuestion.id = this.testService.generateQID();

    console.log("TEST HEAD COMPONENT:");
    if (this.test.questions.length < MAX_NUMBER_OF_QUESTIONS) {
      this.test.questions.push(newQuestion);
      console.log("New question with id " + newQuestion.id + " added");
    } else {
      console.log("New question can not be added: limit of questions is " + MAX_NUMBER_OF_QUESTIONS);
      this.maxNumberOfQuestionsError = "Maximal number of questions is 50";
    }
  }
}
