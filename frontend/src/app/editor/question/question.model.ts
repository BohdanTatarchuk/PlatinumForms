import {Option} from './option.model';

export interface Question {
  name: string;
  id: string;
  obligatory: boolean;
  type: number;
  options: Array<Option>;
}
