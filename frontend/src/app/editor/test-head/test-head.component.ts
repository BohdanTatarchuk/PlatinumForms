import {Component} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {TestService} from '../../services/test.service';
import {Test} from '../test.model';

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
      options: [],
      answered: []
    }

    newQuestion.id = this.testService.generateQID();
    this.test.questions.push(newQuestion);

    console.log("On added: \n");
    for (let i = 0; i < this.test.questions.length; i++) {
      console.log(this.test.questions[i].id + ", ");
    }
  }
}
