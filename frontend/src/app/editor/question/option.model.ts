import {TrueQuestion} from './question.model';

export interface Option {
  name: string;
  correct: boolean;
  id: string;
}

export interface TrueOption {
  id: string;
  correct: boolean;
  text: string;
  question : TrueQuestion | null;
}
