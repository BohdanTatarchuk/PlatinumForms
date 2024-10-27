import {Injectable} from '@angular/core';

@Injectable({
  providedIn: "root"
})
export class GlobalService{
  public is_logged: boolean = false;
  public email: string = "";
  public photo: string = "";
  public username: string = "";

  constructor() {}
}
