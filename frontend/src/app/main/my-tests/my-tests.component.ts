import {Component, inject} from '@angular/core';
import {MyTestComponent} from './my-test/my-test.component';
import { DUMMY_TESTS } from './my-test/dummy-data';
import {Router} from '@angular/router';

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
  tests = DUMMY_TESTS;

  router = inject(Router);

  onSelectTest(id: string): void {
    console.log("Selected test with id " + id);
  }

  onSelectNewTest(): void {
    this.router.navigate(['/editor']);
  }
}
