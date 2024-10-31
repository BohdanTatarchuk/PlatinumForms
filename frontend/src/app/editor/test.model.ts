import {Question} from './question/question.model';

export interface Test {
  name: string;
  id: string;
  description: string;
  questions: Array<Question>;
}
