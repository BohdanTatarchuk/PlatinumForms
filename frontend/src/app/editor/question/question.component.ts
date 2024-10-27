import { Component } from '@angular/core';
import {FormsModule} from "@angular/forms";
import { Question } from "./question.model";

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


  onDeleteQuestion(qid: string): void {

  }

  onSelectedType(choice: number) {

  }

  generateQID(): void {
    //this.setQID(Date.now().toString(36) + Math.random().toString(36).substring(2));
  }
}

