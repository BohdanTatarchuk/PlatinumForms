import {Injectable} from '@angular/core';
import {Test} from '../editor/test.model';

@Injectable({
  providedIn: "root"
})
export class GlobalService{
  public is_logged: boolean = false;
  public email: string = "";
  public photo: string = "";
  public username: string = "";
  public tests: Array<Test> | undefined;

  constructor() {}
}
