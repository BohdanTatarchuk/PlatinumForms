import { Component } from '@angular/core';
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-question',
  standalone: true,
    imports: [
        FormsModule
    ],
  templateUrl: './question.component.html',
  styleUrl: './question.component.css'
})

export class QuestionComponent {
  questionName: string = '';
  QID: string = '';
  obligatory: boolean = false;
  questionType: number = 1;

  getObligatory(): boolean {
    return this.obligatory;
  }

  setObligatory(value: boolean) {
    this.obligatory = value;
  }

  getQuestionType(): number {
    return this.questionType;
  }

  setQuestionType(value: number) {
    this.questionType = value;
  }

  getQuestionName(): string {
    return this.questionName;
  }

  setQuestionName(name: string): void {
    this.questionName = name;
  }

  getQID(): string {
    return this.QID;
  }

  setQID(value: string) {
    this.QID = value;
  }

  onDeleteQuestion(qid: string): void {

  }

  onSelectedType(choice: number) {

  }

  generateQID(): void {
    this.setQID(Date.now().toString(36) + Math.random().toString(36).substring(2));
  }
}

