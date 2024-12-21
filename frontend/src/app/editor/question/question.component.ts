import {Component, Input} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {QuestionWithOptions} from "./question.model";
import {NgIf} from '@angular/common';
import {TestService} from '../../services/test.service';
import {TestWithQuestions} from '../test.model';
import {TrueOption} from './option.model';

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

  test!: TestWithQuestions | null;

  enteredOption!: string;
  errorHint: string = "";
  maxNumberError: string = "";

  ngOnInit() {
    this.updateInfo();
    this.test = JSON.parse(sessionStorage.getItem("test")!);
  }

  @Input() question!: QuestionWithOptions;

  onDeleteQuestion(id: string): void {
    this.updateInfo();
    this.test!.questions = this.test!.questions.filter(item => item.id !== id);
    this.testService.updateTest(this.test!);
  }

  onSelectedType() {
    const currentQuestion = this.test!.questions.find(item => item.id === this.question.id);
    if (currentQuestion) {
      currentQuestion.options = [];
      this.onAddNewAnswer();
    }
  }

  onAddNewOption() {
    this.updateInfo();
    const newOption = {
      text: '',
      id: '',
      correct: false,
      question: {
        questionText: this.question.text,
        questionType: this.question.type,
        test: {
          name: this.test!.name,
          description: this.test!.description,
          id: this.test!.id,
          authorEmail: this.test!.authorEmail
        },
        id: this.question.id,
        obligatory: this.question.obligatory
      }
    }
    newOption.id = this.testService.generateQID();

    this.checkLimit(newOption);
    this.testService.updateTest(this.test!);
  }

  onDeleteOption(id: string): void {
    this.updateInfo();
    const question = this.test!.questions.find(item => item.id === this.question.id);

    if (question) {
      question.options = question.options.filter(option => option.id !== id);
    }
    this.testService.updateTest(this.test!);
  }

  onAddNewAnswer() {
    this.updateInfo();
    console.log("QUESTION COMPONENT:");
    const newOption = {
      text: '',
      id: '',
      correct: false,
      question: {
        questionText: this.question.text,
        questionType: this.question.type,
        test: {
          name: this.test!.name,
          description: this.test!.description,
          id: this.test!.id,
          authorEmail: this.test!.authorEmail
        },
        id: this.question.id,
        obligatory: this.question.obligatory
      }
    }

    if (this.enteredOption == undefined
      || this.enteredOption.trim().length === 0) {
      this.errorHint = "Option's name can not be empty";

      console.log("New option can not be added: name is empty");
    } else if (this.enteredOption.trim().length >= MAX_NAME_SIZE) {
      this.errorHint = "Option's name is too long";

      console.log("New option can not be added: name's length is over " + MAX_NAME_SIZE + " characters");
    } else {
      newOption.text = this.enteredOption;
      newOption.id = this.testService.generateQID();

      this.checkLimit(newOption);
      this.errorHint = "";
    }
  }

  checkLimit(newOption: TrueOption) {
    this.testService.logTestWithQuestions(this.test!);
    if (this.test!.questions.find(item => item.id === this.question.id)!.options.length < MAX_NUMBER_OF_OPTIONS) {
      this.test!.questions.find(item => item.id == this.question.id)?.options.push(newOption);
      console.log("New option with id " + newOption.id + " added");
    } else {
      console.log("New option can not be added: limit of options is " + MAX_NUMBER_OF_OPTIONS);
      this.maxNumberError = "Maximal number of options is 20";
    }
  }

  onSelectOption(selectedOption: TrueOption) {
    this.updateInfo();
    this.question.options.forEach(option => {
      option.correct = option === selectedOption
      console.log("Option " + option.text + " is correct " + option.correct);
    });
    this.testService.updateTest(this.test!);
  }

  updateInfo() {
    this.testService.test$.subscribe((test) => {
      if (test) {
        this.test = test;
      }
    });
  }
}

