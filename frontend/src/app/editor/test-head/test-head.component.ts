import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-test-head',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './test-head.component.html',
  styleUrl: './test-head.component.css'
})




export class TestHeadComponent {
  testName: string = '';
  testDescription: string = '';

  getTestName(): string {
    return this.testName;
  }

  setTestName(name: string): void {
    this.testName = name;
  }

  getTestDescription(): string {
    return this.testDescription;
  }

  setTestDescription(description: string): void {
    this.testDescription = description;
  }
}
