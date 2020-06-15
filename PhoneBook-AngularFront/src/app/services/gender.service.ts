import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {IGender} from '../model/gender';
import {catchError, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class GenderService {
  private apiURL = `http://localhost:8080/`;

  constructor(private httpClient: HttpClient) { }

  getAllGender(): Observable<IGender[]> {
    console.log('Get gender from api');
    const resourceURL = this.apiURL + `gender`;
    return this.httpClient.get<IGender[]>(resourceURL).pipe();
  }

}
