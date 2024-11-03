import {Option} from './option.model';

export interface Question {
  name: string;
  id: string;
  obligatory: boolean;
  type: number;
  mark: number | null;
  options: Array<Option>;
  answered: Array<string>;
}
