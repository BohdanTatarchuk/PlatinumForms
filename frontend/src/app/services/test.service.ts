import {Injectable} from '@angular/core';
import {Test, TestWithQuestions, TrueTest} from '../editor/test.model';
import {BehaviorSubject} from 'rxjs';

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
  private testSource = new BehaviorSubject<TestWithQuestions | null>(null); // Holds the current Test object
  test$ = this.testSource.asObservable(); // Expose the observable

  updateTest(newTest: TestWithQuestions): void {
    this.testSource.next(newTest); // Notify subscribers
  }

  logTestWithQuestions(test: TestWithQuestions): void {
    console.log('Test Information:');
    console.log(`Name: ${test.name || 'N/A'}`);
    console.log(`Description: ${test.description || 'N/A'}` );
    console.log(`ID: ${test.id || 'N/A'}`);
    console.log('User Information:');
    if (test.authorEmail) {
      console.log(`  Username: ${test.authorEmail.username || 'N/A'}`);
      console.log(`  Email: ${test.authorEmail.email || 'N/A'}`);
      console.log(`  Photo: ${test.authorEmail.photo || 'N/A'}`);
    } else {
      console.log('  User is undefined.');
    }
    console.log('Questions:');
    test.questions?.forEach((question, index) => {
      console.log(`  Question ${index + 1}: ${question.id|| 'N/A'}`);
      question.options?.forEach((option, optIndex) => {
        console.log(`    Option ${optIndex + 1}: ${option.id || 'N/A'}`);
      });
    });
  }
}
