import {Component, EventEmitter, inject, Input, Output} from '@angular/core';
import {Router} from '@angular/router';
import {TestWithQuestions, TrueTest} from '../../../editor/test.model';
import {HttpClient} from '@angular/common/http';
import {forkJoin, Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {TrueQuestion} from '../../../editor/question/question.model';
import {TrueOption} from '../../../editor/question/option.model';
import {TestService} from '../../../services/test.service';

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

  constructor(private testService: TestService ) {}

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
    this.getTest(this.test.id).subscribe({
      next : (val) =>{
        this.mainTest = val;
        if (!this.mainTest) {
          return;
        }
        this.testService.logTestWithQuestions(this.mainTest);
        sessionStorage.setItem("test", JSON.stringify(this.mainTest));
        this.router.navigate(['/editor']);
      }
    });
  }

  getTest(Id : String): Observable<TestWithQuestions>{
    return this.httpClient.get<TestWithQuestions>(URL + "/tests/test/" + Id);
  }
}
