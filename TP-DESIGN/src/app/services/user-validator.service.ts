import { Injectable } from '@angular/core';
import { FormControl, ValidatorFn } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class UserValidatorService {

  constructor() { }
  static validatorNoSpace():ValidatorFn | any {
    return (control:FormControl) =>{
      return (control.value || '').trim().length === 0 ? {'whitespace':true}:null;
    }
  }
}
