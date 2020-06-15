import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IPerson} from '../model/person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  private apiURL = `http://localhost:8080/`;

  constructor(private httpClient: HttpClient) { }

  getAllPerson(): Observable<IPerson[]> {
    const resourceURL = this.apiURL + `person`;
    return this.httpClient.get<IPerson[]>(resourceURL).pipe();
  }

  getAllPersonWithPhone(): Observable<IPerson[]> {
    const resourceURL = this.apiURL + `person/phone`;
    return this.httpClient.get<IPerson[]>(resourceURL).pipe();
  }

  getPersonById(id: number): Observable<IPerson> {
    const resourceURL = this.apiURL + `person/` + id;
    return this.httpClient.get<IPerson>(resourceURL).pipe();
  }

  addPerson(person: IPerson) {
    const resourceURL = this.apiURL + `person`;
    return this.httpClient.post(resourceURL, person);
  }

  editPerson(person: IPerson) {
    const resourceURL = this.apiURL + `person`;
    return this.httpClient.patch(resourceURL, person);
  }

  deletePerson(person: IPerson) {
    const resourceURL = this.apiURL + `person`;
    const options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
      body: person
    };
    return this.httpClient.delete(resourceURL, options);
  }
}
