import {Component, EventEmitter, inject, Input, Output} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-test',
  standalone: true,
  imports: [],
  templateUrl: './my-test.component.html',
  styleUrl: './my-test.component.css'
})

export class MyTestComponent {
  router = inject(Router);

  @Input({ required: true }) test!: {
    id: string;
    code: string;
    name: string;
  }

  @Output() select = new EventEmitter<string>();

  onSelectedTest(): void {
    this.select.emit(this.test.id);
    //this.router.navigate(['/editor']);
  }
}
