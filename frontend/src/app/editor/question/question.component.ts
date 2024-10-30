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

  ngOnInit() {
    this.test = this.testService.getTest();
  }

  @Input() question!: Question;

  onDeleteQuestion(id: string): void {
    this.test.questions = this.test.questions.filter(item => item.id !== id);
  }

  onSelectedType(choice: number) {

  }

  onAddNewOption() {
    const newOption = {
      name: '',
      id: '',
      correct: false
    }

    newOption.id = this.testService.generateQID();
    this.test.questions.find(item => item.id == this.question.id)?.options.push(newOption);
  }

  onDeleteOption(id: string): void {
    //this.test.questions.find(item => item.id == this.question.id)?.options
    //  = this.test.questions.find(item => item.id == this.question.id)?.options.filter(item => item.id !== id);
  }

  onAddNewAnswer() {

  }
}

