import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {IPhone} from '../model/phone';

@Injectable({
  providedIn: 'root'
})
export class PhoneService {
  private apiURL = `http://localhost:8080/`;

  constructor( private httpClient: HttpClient ) { }

  getAllPhones(): Observable<IPhone[]> {
    const resourceURL = this.apiURL + `phone`;
    return this.httpClient.get<IPhone[]>(resourceURL).pipe();
  }

  getAllPhonesByPersonId(id: number): Observable<IPhone[]> {
    const resourceURL = this.apiURL + `phone/person/` + id;
    return this.httpClient.get<IPhone[]>(resourceURL ).pipe();
  }

  addPhone(phone: IPhone) {
    const resourceURL = this.apiURL + `phone`;
    this.httpClient.post(resourceURL, phone).subscribe((ok) => {console.log(ok); });
  }

  addPhoneToPerson(phoneNumber: string, personId: number) {
    const resourceURL = this.apiURL + `phone/` + phoneNumber + `/person/` + personId;
    return this.httpClient.post(resourceURL, null).pipe();
  }

  editPhone(phone: IPhone) {
    const resourceURL = this.apiURL + `phone`;
    this.httpClient.patch(resourceURL, phone).subscribe((ok) => {console.log(ok); });
  }

  deletePhone(phoneId: number) {
    const phone = { id: phoneId};
    const resourceURL = this.apiURL + `phone`;
    const options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
      body: phone
    };
    return this.httpClient.delete(resourceURL, options);
  }

  deletePhoneByPersonId(personId: number) {
    const resourceURL = this.apiURL + `phone/person/` + personId;
    return this.httpClient.delete(resourceURL)
  }

}
