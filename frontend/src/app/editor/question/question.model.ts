import {Option, TrueOption} from './option.model';
import {TrueTest} from '../test.model';

export interface Question {
  name: string;
  id: string;
  obligatory: boolean;
  type: number;
  mark: number | null;
  options: Array<Option>;
  answered: Array<string>;
}

export interface QuestionWithOptions {
  text: string;
  type: number;
  test: TrueTest | null;
  id: string;
  obligatory: boolean;
  options: Array<TrueOption>;
}

export interface TrueQuestion {
  questionText: string;
  questionType: number;
  test: TrueTest | null;
  id: string;
  obligatory: boolean;
}
