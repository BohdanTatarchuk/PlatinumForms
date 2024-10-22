import { Component } from '@angular/core';
import {EditorComponent} from '../editor.component';

@Component({
  selector: 'app-question',
  standalone: true,
  imports: [ ],
  templateUrl: './question.component.html',
  styleUrl: './question.component.css'
})

export class QuestionComponent {

}

function generateQID(): string {
  return  Date.now().toString(36) + Math.random().toString(36).substring(2);;
}

console.log('QuestionComponent generateQID:', generateQID());
