import {Component, inject} from '@angular/core';
import {MyTestComponent} from './my-test/my-test.component';
import { DUMMY_TESTS } from './my-test/dummy-data';
import {Router} from '@angular/router';
import {Test} from '../../editor/test.model';
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

  tests: any;

  router = inject(Router);

  ngOnInit() {
    this.tests = this.globalService.tests;
    console.log("User with following test received on main: " + this.tests);
  }

  onSelectTest(id: string): void {
    console.log("Selected test with id " + id);
  }

  onSelectNewTest(): void {
    this.router.navigate(['/editor']);
  }
}
