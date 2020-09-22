import { Injectable } from '@angular/core';
import {Actions, ofActionSuccessful} from '@ngxs/store';
import {CreateEmployee, DeleteEmployee, UpdateEmployee} from '../state/employees/employees.actions';
import {Location} from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class RouteHandler {

  constructor(
    private actions$: Actions,
    private location: Location,
  ) {

    // go back if employee created
    this.actions$.pipe(ofActionSuccessful(CreateEmployee, UpdateEmployee, DeleteEmployee)).subscribe(result => {
      this.location.back();
    });
  }
}
