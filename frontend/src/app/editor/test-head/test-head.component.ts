import {Component} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {UserService} from '../../services/user.service';
import { Question} from '../question/question.model';
import {User} from '../../registration/registration-window/user.model';
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
  constructor(private testService: TestService ) {}

  test!: Test;

  ngOnInit() {
    this.test = this.testService.getTest();

    console.log(
      "Received tests in TestHeadComponent with the following data: "
      + this.test.id + ", "
      + this.test.name + ", "
      + this.test.questions
    );
  }

  emptyQuestion: Question = {
    name: '',
    id: '',
    obligatory: false,
    type: 0,
    options: []
  }

  onAddQuestion(): void {
    this.test.questions.push(this.emptyQuestion);
  }
}
