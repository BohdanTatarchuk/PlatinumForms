import {Question} from './question/question.model';

export interface Test {
  name: string;
  id: string;
  code: string;
  description: string;
  questions: Array<Question>;
}