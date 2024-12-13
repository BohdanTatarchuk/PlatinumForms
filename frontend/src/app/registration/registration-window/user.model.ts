import {Test} from '../../editor/test.model';

export interface User {
    email: string;
    username: string;
    password: string;
    tests: Array<Test>
}

export interface UserT {
  username: string;
  email: string;
  password: string;
  photo: string;
}
