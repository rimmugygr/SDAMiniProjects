import { Injectable } from '@angular/core';
import {HttpErrorResponse} from '@angular/common/http';
import {throwError} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ConsoleErrorService {

  constructor() { }

  // code to catch error in pipe
  // tap(data => console.log('Success received data from ' + resourceURL + JSON.stringify(data))),
  // catchError(this.handleError)

  public handleError(err: HttpErrorResponse) {
    let errorMessage = '';
    if (err.error instanceof ErrorEvent) {
      errorMessage = `Error occurred: ${err.error.message}`;
    } else {
      errorMessage = `Server return code ${err.status} Error occurred: ${err.message}`;
    }
    console.log('Some Error with data from ' + err.url);
    console.log(errorMessage);
    return throwError(errorMessage);
  }
}
