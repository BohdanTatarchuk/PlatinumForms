import {Component, Input} from '@angular/core';
import {FormsModule} from "@angular/forms";
import { Question } from "./question.model";
import {NgIf} from '@angular/common';
import {TestService} from '../../services/test.service';
import {Test} from '../test.model';
import {Option} from './option.model';

@Component({
  selector: 'app-question',
  standalone: true,
  imports: [
    FormsModule,
    NgIf
  ],
  templateUrl: './question.component.html',
  styleUrl: './question.component.css'
})

export class QuestionComponent {
  constructor(private testService: TestService ) {}

  test!: Test;

  enteredOption!: string;
  errorHint: string = "Type your option here...";

  ngOnInit() {
    this.test = this.testService.getTest();
  }

  @Input() question!: Question;

  onDeleteQuestion(id: string): void {
    this.test.questions = this.test.questions.filter(item => item.id !== id);
  }

  onSelectedType() {
    const currentQuestion = this.test.questions.find(item => item.id === this.question.id);
    if (currentQuestion) {
      currentQuestion.options = [];
      this.onAddNewAnswer();
    }
  }

  onAddNewOption() {
    const newOption = {
      name: '',
      id: '',
      correct: false
    }

    newOption.id = this.testService.generateQID();

    console.log("-------------------------------\n");
    console.log("New option with id: " + newOption.id + "\n");

    this.test.questions.find(item => item.id == this.question.id)?.options.push(newOption);
  }

  onDeleteOption(id: string): void {
    const question = this.test.questions.find(item => item.id === this.question.id);

    if (question) {
      question.options = question.options.filter(option => option.id !== id);
    }
  }

  onAddNewAnswer() {
    const newOption = {
      name: '',
      id: '',
      correct: false
    }

    if (this.enteredOption == undefined
      || this.enteredOption.trim().length === 0) {
      this.errorHint = "This field can not be empty!"
    } else if (this.enteredOption.trim().length >= 80) {
      this.errorHint = "This option is to long!"
    } else {
      newOption.name = this.enteredOption;
      newOption.id = this.testService.generateQID();
      this.test.questions.find(item => item.id == this.question.id)?.options.push(newOption);

      console.log("-------------------------------\n");
      console.log("New option with id: " + newOption.id + "\n");
    }
  }

  /*checkStats() {
    console.log("---------------------------------------\n");
    console.log("Question id: " + this.question.id + "\n");
    console.log("Question name: " + this.question.name + "\n");
    console.log("Question obligatory: " + this.question.obligatory + "\n");
  }*/
}

