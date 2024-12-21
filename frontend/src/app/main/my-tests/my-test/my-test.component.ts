import {Component, EventEmitter, inject, Input, Output} from '@angular/core';
import {Router} from '@angular/router';
import {TestWithQuestions, TrueTest} from '../../../editor/test.model';
import {HttpClient} from '@angular/common/http';
import {forkJoin, Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {TrueQuestion} from '../../../editor/question/question.model';
import {TrueOption} from '../../../editor/question/option.model';

const URL: string = 'http://localhost:8080';

@Component({
  selector: 'app-my-test',
  standalone: true,
  imports: [],
  templateUrl: './my-test.component.html',
  styleUrls: ['./my-test.component.css']
})
export class MyTestComponent {
  router = inject(Router);
  private httpClient = inject(HttpClient);

  private mainTest: TestWithQuestions = {
    id: '',
    name: '',
    description: '',
    authorEmail: {username: '', email: '', password: '', photo: ''},
    questions: []
  };

  @Input({ required: true }) test!: TrueTest;
  @Output() select = new EventEmitter<string>();

  async onSelectedTest(): Promise<void> {
    this.mainTest.authorEmail = this.test.authorEmail;
    this.mainTest.id = this.test.id;
    this.mainTest.name = this.test.name;
    this.mainTest.description = this.test.description;
    this.getQuestions().subscribe({
      next: (questions) => {
        const questionObservables = questions.map((question) =>
          this.getOptions(question.id).pipe(
            map((options) => ({
              id: question.id,
              test: question.test,
              type: question.questionType,
              text: question.questionText,
              obligatory: question.obligatory,
              options: options
            }))
          )
        );
        forkJoin(questionObservables).subscribe({
          next: (fullQuestions) => {
            this.mainTest.questions = fullQuestions;
            sessionStorage.setItem("test", JSON.stringify(this.mainTest));
            this.router.navigate(['/editor']);
          }
        });
      }
    });
  }

  getQuestions(): Observable<TrueQuestion[]> {
    console.log("TEST ID: " + this.test.id);
    return this.httpClient.get<TrueQuestion[]>(URL + "/questions/test/" + this.test.id);
  }

  getOptions(id: string): Observable<TrueOption[]> {
    return this.httpClient.get<TrueOption[]>(URL + "/options/question/" + id);
  }

}
