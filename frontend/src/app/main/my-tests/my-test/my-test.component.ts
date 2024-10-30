import {Component, EventEmitter, inject, Input, Output} from '@angular/core';
import { Router } from '@angular/router';
import { TestService } from '../../../services/test.service';
import { Test } from '../../../editor/test.model';

@Component({
  selector: 'app-my-test',
  standalone: true,
  imports: [],
  templateUrl: './my-test.component.html',
  styleUrl: './my-test.component.css'
})

export class MyTestComponent {
  router = inject(Router);

  constructor(private testService: TestService) {}


  @Input({ required: true }) test!: Test;
  @Output() select = new EventEmitter<string>();

  onSelectedTest(): void {
    this.testService.setTest(this.test);
    this.select.emit(this.test.id);
    this.router.navigate(['/editor']);
  }
}
