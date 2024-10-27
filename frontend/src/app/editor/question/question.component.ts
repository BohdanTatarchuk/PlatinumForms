import {Component, Input} from '@angular/core';
import {FormsModule} from "@angular/forms";
import { Question } from "./question.model";
import {NgIf} from '@angular/common';

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
  @Input() question!: Question;

  onDeleteQuestion(qid: string): void {

  }

  onSelectedType(choice: number) {

  }

  generateQID(): void {
    //this.setQID(Date.now().toString(36) + Math.random().toString(36).substring(2));
  }

  onAddNewOption() {

  }

  onAddNewAnswer() {

  }
}

