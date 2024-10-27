import {Component, inject} from '@angular/core';
import {MyTestComponent} from './my-test/my-test.component';
import {DUMMY_TESTS} from './my-test/dummy-data';
import {Router} from '@angular/router';
import {FAKE_DATA} from '../../registration/registration-window/fake-data';
import {GlobalService} from '../../services/global.service';

@Component({
  selector: 'app-my-tests',
  standalone: true,
  imports: [
    MyTestComponent
  ],
  templateUrl: './my-tests.component.html',
  styleUrl: './my-tests.component.css'
})

export class MyTestsComponent {
  constructor(public globalService: GlobalService) {}

  data = FAKE_DATA;
  user_tests: any;

  router = inject(Router);

  ngOnInit() {
    const user = this.data.find(user => user.email === this.globalService.email)
    this.user_tests = user?.test;
    console.log(this.user_tests)
  }

  onSelectTest(id: string): void {
    console.log("Selected test with id " + id);
  }

  onSelectNewTest(): void {
    this.router.navigate(['/editor']);
  }
}
