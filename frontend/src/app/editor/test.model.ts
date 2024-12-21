import {Question, QuestionWithOptions} from './question/question.model';
import {UserT} from '../registration/registration-window/user.model';

export interface Test {
  name: string;
  id: string;
  description: string;
  mark: number | null;
  questions: Array<Question>;
}

export interface TestWithQuestions {
  name: string;
  description: string;
  id: string;
  authorEmail: UserT;
  questions: Array<QuestionWithOptions>;
}

export interface TrueTest {
  name: string;
  description: string;
  id: string;
  authorEmail: UserT;
}
