import { Component, Input } from '@angular/core';
import { TestService } from '../../services/test.service';
import { Question } from '../../editor/question/question.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-test-question',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './test-question.component.html',
  styleUrls: ['./test-question.component.css']
})
export class TestQuestionComponent {
  constructor(private testService: TestService) {}

  @Input() question!: Question;

  multiple_choice_selection: Array<string> = [];

  selectedRadio: string | undefined;

  free_answer: string | undefined;

  onCheckedOption(id: string, event: Event) {
    const isChecked = (event.target as HTMLInputElement).checked;
    if (isChecked) {
      if (!this.multiple_choice_selection.includes(id)) {
        this.multiple_choice_selection.push(id);
      }
    } else {
      this.multiple_choice_selection = this.multiple_choice_selection.filter(optionId => optionId !== id);
    }
    console.log("Checkbox Selection:", this.multiple_choice_selection);
  }

  onRadioSelect(id: string) {
    this.selectedRadio = id;
    console.log("Radio Selection:", this.selectedRadio);
  }
  onFreeAnswerChange() {
    console.log("Free Answer:", this.free_answer);
  }
}
