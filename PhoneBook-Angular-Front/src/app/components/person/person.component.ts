import { Component, OnInit } from '@angular/core';
import {PersonService} from '../../services/person.service';
import {IPerson} from '../../model/person';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {IGender} from '../../model/gender';
import {GenderService} from '../../services/gender.service';
import {PhoneService} from '../../services/phone.service';
import {IPhone} from '../../model/phone';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {
  personList: IPerson[] = null ;
  genderList: IGender[] = null ; // [{name: 'M'}, {name: 'F'}];
  personNewForm: FormGroup;
  personEditForm: FormGroup;
  enableForm = 'none';
  message = '';
  enableFormPhone: string | number = `none`;
  phoneNewForm: FormGroup;

  constructor(
    private personService: PersonService,
    private genderService: GenderService,
    private phoneService: PhoneService
  ) { }

  ngOnInit(): void {
    this.getAllPerson();
    this.getAllGender();
  }

  public getAllPerson() {
    this.personService.getAllPerson().subscribe(
      data => this.personList = data as IPerson[],
      err => console.error(err),
      () => this.message = 'Load All Persons'
    );
  }

  public getAllGender() {
    this.message = 'Load All Person';
    this.genderService.getAllGender().subscribe(
      data => this.genderList = data as IGender[],
      err => console.error(err),
      () => console.log('Load All Gender')
    );
  }

  public getPersonById(id: number) {
    this.personService.getPersonById(id).subscribe(
      data => this.personList = data as unknown as IPerson[],
      err => console.error(err),
      () => console.log(`person` + id + ` loaded`)
    );
  }

  public getPersonWithPhone() {
    this.personService.getAllPersonWithPhone().subscribe(
      data => this.personList = data as IPerson[],
      err => console.error(err),
      () =>  this.message = `Load All Persons With Phone`
    );
  }

  public deletePerson(person: IPerson) {
    this.personService.deletePerson(person).subscribe(
      null,
      err => console.error(err),
      () =>  this.message = `Delete Person With Id ` + person.id
    );
  }

  public submitFormNewPerson() {
    if (this.personNewForm.valid) {
      this.disableForm();
      const personNew: IPerson = this.personNewForm.value;
      const gender: IGender = {name: ``};
      gender.name = this.personNewForm.value.gender;
      personNew.gender = gender;
      console.log(personNew);
      this.addNewPerson(personNew);
      this.personNewForm.reset();
    } else {
      this.message = 'Pleas Fill Form Correct';
    }

  }

  private addNewPerson(personNew: IPerson) {
    this.personService.addPerson(personNew).subscribe(
      null,
      err => console.error(err),
      () => this.message = 'Added New Person'
    );
  }

  public createFormNewPerson() {
    this.personNewForm = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      age: new FormControl('', Validators.pattern(`[0-9]+`)),
      gender: new FormControl(  '', Validators.required)
    });
    this.enableForm = 'new';
    this.message = `New Person Form`;
  }

  public createFormEditPerson(person: IPerson) {
    this.personEditForm = new FormGroup({
      id: new FormControl(person.id ),
      firstName: new FormControl(person.firstName),
      lastName: new FormControl(person.lastName),
      age: new FormControl(person.age, Validators.pattern(`[0-9]*`)),
      gender: new FormControl(person.gender.name)
    });
    this.enableForm = 'edit';
    this.message = `Edit Person Id ` + person.id + ` Form`;
  }

  public submitFormEditPerson() {
    if (this.personEditForm.valid) {
      this.disableForm();
      const personEdit: IPerson = this.personEditForm.value;
      const gender: IGender = {name: ``};
      gender.name = this.personEditForm.value.gender;
      personEdit.gender = gender;
      console.log(personEdit);
      this.editPerson(personEdit);
      this.personEditForm.reset();
    } else {
      this.message = 'Pleas Fill Form Correct';
    }
  }

  public disableForm() {
    this.enableForm = `none`;
  }

  private editPerson(personEdit: IPerson) {
    this.personService.editPerson(personEdit).subscribe(
      null,
      err => console.error(err),
      () => this.message = 'Edit Person Id ' + personEdit.id
    );
  }

  public createFormNewPhone(id: number) {
    this.phoneNewForm = new FormGroup({
      number: new FormControl('', Validators.required),
      personId: new FormControl(id)
    });
    this.enableFormPhone = id;
  }

  disableFormPhone() {
    this.enableFormPhone = `none`;
  }

  submitFormNewPhone() {
    if (this.phoneNewForm.valid) {
      this.disableFormPhone();
      console.log(this.phoneNewForm.value);
      this.addPhone(this.phoneNewForm.value.number, this.phoneNewForm.value.personId);
      this.phoneNewForm.reset();
    } else {
      this.message = `Fill correct form`;
    }
  }

  private addPhone(phoneNumber: string, personId: number) {
    this.phoneService.addPhoneToPerson(phoneNumber, personId).subscribe(
      null,
      err => console.error(err),
      () => this.message = 'Add number ' + phoneNumber + ' of person Id ' + personId
    );
  }

  deletePhone(id: number) {
    this.phoneService.deletePhone(id).subscribe(
      null,
      err => console.error(err),
      () => this.message = 'Delete number id ' + id
    );
  }

  deleteAllPhoneByPersonId(id: number) {
    this.phoneService.deletePhoneByPersonId(id).subscribe(
      null,
      err => console.error(err),
      () => this.message = 'Delete all number by person id ' + id
    );
  }
}
