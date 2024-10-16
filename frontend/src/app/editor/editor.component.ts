import { Component } from '@angular/core';
import {TestHeadComponent} from '../test-head/test-head.component';
import {TopHeaderComponent} from '../top-header/top-header.component';

@Component({
  selector: 'app-editor',
  standalone: true,
  imports: [
    TestHeadComponent,
    TopHeaderComponent
  ],
  templateUrl: './editor.component.html',
  styleUrl: './editor.component.css'
})
export class EditorComponent {

}
