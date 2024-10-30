import {Component} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Test} from '../../editor/test.model';
import {TestService} from '../../services/test.service';

@Component({
  selector: 'app-test-head',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './test-head.component.html',
  styleUrl: './test-head.component.css'
})

export class TestHeadComponent {

  constructor(private testService: TestService ) {}

  name: string = "";
  description: string = "";

  test!: Test;

  ngOnInit(){
    this.test = this.testService.getTest();
    this.name = this.test.name;
    this.description = this.test.description;
  }
}
