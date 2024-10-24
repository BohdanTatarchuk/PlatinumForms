import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { DUMMY_TESTS} from './dummy-data';

const randomIndex = Math.floor(Math.random() * 5);

@Component({
  selector: 'app-my-test',
  standalone: true,
  imports: [],
  templateUrl: './my-test.component.html',
  styleUrl: './my-test.component.css'
})

export class MyTestComponent {
  router = inject(Router);

  selectedTest = DUMMY_TESTS[randomIndex];

  onSelectedTest(): void {
    console.log(DUMMY_TESTS[randomIndex].name + ' was selected');
    this.router.navigate(['/editor']);
  }
}
