import { Component } from '@angular/core';
import {TestHeadComponent} from '../test-head/test-head.component';
import {TopHeaderComponent} from '../top-header/top-header.component';
import {QuestionComponent} from "./question/question.component";

@Component({
  selector: 'app-editor',
  standalone: true,
    imports: [
        TestHeadComponent,
        TopHeaderComponent,
        QuestionComponent
    ],
  templateUrl: './editor.component.html',
  styleUrl: './editor.component.css'
})
export class EditorComponent {

}
