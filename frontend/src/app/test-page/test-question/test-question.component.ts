import {Component, Input} from '@angular/core';
import {Question} from '../../editor/question/question.model';
import {FormControl, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {debounceTime, Subject} from 'rxjs';
import {TestService} from '../../services/test.service';
import {Test} from '../../editor/test.model';

@Component({
  selector: 'app-test-question',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './test-question.component.html',
  styleUrls: ['./test-question.component.css']
})
export class TestQuestionComponent {

  @Input() saveTrigger!: Subject<void>;

  constructor(private testService: TestService) {}

  textInputControl = new FormControl<string>('');
  test!: Test;

  @Input() question!: Question;
  mark: number | null = null;
  correctAnswers: string[] = [];

  ngOnInit() {
    this.saveTrigger.subscribe(() => this.setMark());
    this.test = this.testService.getTest();

    this.textInputControl.valueChanges
      .pipe(debounceTime(250))
      .subscribe((value: string | null) => this.onAnswered(value!));

  }

  setMark() {
    this.mark = this.question.mark;
    this.displayCorrectAnswers();
  }

  onCheckedOption(id: string, event: Event) {
    const isChecked = (event.target as HTMLInputElement).checked;
    if (isChecked) {
      if (!this.question.answered.includes(id)) {
        this.question.answered.push(id);
      }
    } else {
      this.question.answered = this.question.answered.filter(optionId => optionId !== id);
    }

    this.test.questions.forEach(question => {
      if (question.id === this.question.id) {
        question.answered = this.question.answered;
      }
    });
    this.testService.setTest(this.test);

    console.log("Question " + this.question.id + " has the following answers " + this.question.answered)
  }

  onAnswered(id: string) {
    if (id) {
      this.question.answered.splice(0, this.question.answered.length);
      this.question.answered.push(id);

      this.test.questions.forEach(question => {
        if (question.id === this.question.id) {
          question.answered = this.question.answered;
        }
      });
      this.testService.setTest(this.test);
    }

    console.log("Question " + this.question.id + " has the following answers " + this.question.answered);
  }

  displayCorrectAnswers() {
    if(!this.question) {
      return;
    }

    for (let i = 0; i < this.question.options.length; i++) {
      if (this.question.options[i].correct) {
        this.correctAnswers.push(this.question.options[i].name);
        console.log(this.correctAnswers);
      }
    }
  }

  toString(answerArray: string[]): string {
    let answer: string = "";

    for (let i = 0; i < answerArray.length; i++) {
      answer += answerArray[i] + ", " ;
    }

    return answer.substring(0, answer.length - 2);
  }
}
