import {Test} from '../../editor/test.model';

export interface User{
    email: string;
    username: string;
    password: string;
    tests: Array<Test>
}
