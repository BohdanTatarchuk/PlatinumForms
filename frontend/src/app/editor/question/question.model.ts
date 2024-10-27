import {Option} from '@angular/cli/src/command-builder/utilities/json-schema';

export interface Question {
  name: string;
  id: string;
  obligatory: boolean;
  type: number;
}
