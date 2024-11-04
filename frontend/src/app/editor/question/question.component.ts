import {Component, Input} from '@angular/core';
import {FormsModule} from "@angular/forms";
import { Question } from "./question.model";
import {NgIf} from '@angular/common';
import {TestService} from '../../services/test.service';
import {Test} from '../test.model';
import {Option} from './option.model';

const MAX_NUMBER_OF_OPTIONS: number = 20;
const MAX_NAME_SIZE: number = 80;

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
  errorHint: string = "";
  maxNumberError: string = "";

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

    this.checkLimit(newOption);
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
      this.errorHint = "Option's name can not be empty";

      console.log("QUESTION COMPONENT:");
      console.log("New option can not be added: name is empty");
    } else if (this.enteredOption.trim().length >= MAX_NAME_SIZE) {
      this.errorHint = "Option's name is too long";

      console.log("QUESTION COMPONENT:");
      console.log("New option can not be added: name's length is over " + MAX_NAME_SIZE + " characters");
    } else {
      newOption.name = this.enteredOption;
      newOption.id = this.testService.generateQID();

      this.checkLimit(newOption);
      this.errorHint = "";
    }
  }

  checkLimit(newOption: Option) {
    console.log("QUESTION COMPONENT:");
    if (this.test.questions.find(item => item.id === this.question.id)!.options.length < MAX_NUMBER_OF_OPTIONS) {
      this.test.questions.find(item => item.id == this.question.id)?.options.push(newOption);
      console.log("New option with id " + newOption.id + " added");
    } else {
      console.log("New option can not be added: limit of options is " + MAX_NUMBER_OF_OPTIONS);
      this.maxNumberError = "Maximal number of options is 20";
    }
  }
}

