import {Component, inject} from '@angular/core';
import {MyTestComponent} from '../my-tests/my-test/my-test.component';
import {FormsModule} from "@angular/forms";
import {Router} from '@angular/router';

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
  router = inject(Router)

  code: string = '';

  navigateToTest(): void {
    this.router.navigate(['/test-page']);
  }

  isEmpty(): boolean {
    return this.code.length == 0;
  }

}
