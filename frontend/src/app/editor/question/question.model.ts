import {Option} from './option.model';

export interface Question {
  name: string;
  id: string;
  obligatory: boolean;
  type: number;
  mark: number;
  options: Array<Option>;
  answered: Array<string>;
}
