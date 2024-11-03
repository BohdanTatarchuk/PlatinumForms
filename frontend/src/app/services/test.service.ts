import {Injectable} from '@angular/core';
import {Test} from '../editor/test.model';

@Injectable({
  providedIn: 'root'
})

export class TestService {
  private test!: Test;
  private id!: string;

  setTest(test: Test) {
    this.test = test;
  }

  getTest() {
    return this.test;
  }

  setTestId(id: string) {
    this.id = id;
  }

  getTestId() {
    return this.id;
  }

  generateQID(): string {
    return Date.now().toString(36) + Math.random().toString(36).substring(2);
  }
}
