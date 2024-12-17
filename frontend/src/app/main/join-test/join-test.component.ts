import {Component, inject} from '@angular/core';
import {MyTestComponent} from '../my-tests/my-test/my-test.component';
import {FormsModule} from "@angular/forms";
import {Router} from '@angular/router';
import {DUMMY_TESTS} from '../my-tests/my-test/dummy-data';
import {TestService} from '../../services/test.service';
import {Test, TrueTest} from '../../editor/test.model';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

const URL: string = 'http://localhost:8080';

@Component({
  selector: 'app-join-test',
  standalone: true,
  imports: [
    MyTestComponent,
    FormsModule
  ],
  templateUrl: './join-test.component.html',
  styleUrl: './join-test.component.css'
})

export class JoinTestComponent {
  constructor(private testService: TestService ) {}

  router = inject(Router)
  private httpClient = inject(HttpClient);

  code: string = '';
  test!: TrueTest;

  joinTest() {
    let info : TrueTest;
      this.getTest(this.code).subscribe({
      next: (val) =>{
        info = val;
        if(val){
          console.log("Value got: " + val);
          //this.testService.setTest(val);
          this.router.navigate(['/test-page']);
        }
      }
    })
  }

  getTest(testId: string): Observable<TrueTest> {
    return this.httpClient.get<TrueTest>(URL + "/tests/" + sessionStorage.getItem("email") + "/" + testId);
  }
}
