import { Injectable } from '@angular/core';
import {Test} from '../editor/test.model';

@Injectable({
  providedIn: 'root'
})

export class TestService {
  private test!: Test;

  setTest(test: Test) {
    this.test = test;
  }

  getTest() {
    return this.test;
  }
}
