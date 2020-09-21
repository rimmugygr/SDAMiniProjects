import { Component, OnInit } from '@angular/core';
import {Employee, EmployeeStatus} from '../../shared/model/employee.model';
import {Observable, Subject} from 'rxjs';
import {Actions, Select, Store} from '@ngxs/store';
import {DisplayEmployees, EmployeesState} from '../../shared/state/employees/employees.state';
import {
  FetchDisplayCompany,
  FetchDisplayPageActual,
  FetchDisplaySearchText,
  FetchDisplayStatus,
  FetchEmployees
} from '../../shared/state/employees/employees.actions';
import {debounceTime} from 'rxjs/operators';
import {faPlus} from '@fortawesome/free-solid-svg-icons/faPlus';


@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {
  icons = {
    faPlus
  };

  employeesStatusEnum = EmployeeStatus;

  private searchSubject = new Subject<string>();
  searchAction$ = this.searchSubject.asObservable()
    .pipe(debounceTime(1000))
    .subscribe(text => this.onSelectSearchText(text));

  @Select(EmployeesState.getCompanies)
  companies$: Observable<string[]>;

  @Select(EmployeesState.getDisplayEmployees)
  displayEmployees$: Observable<DisplayEmployees>;

  constructor(private store: Store) { }

  ngOnInit(): void {
    // this.employees$ = this.store.select(EmployeesState.getEmployees);
    this.store.dispatch( new FetchEmployees());



  }

  onSelectEmployeeStatus(status: string): void {
    this.store.dispatch( new FetchDisplayStatus({status}));
  }

  onSelectEmployeeCompany(selectCompany: string): void {
    this.store.dispatch( new FetchDisplayCompany({company: selectCompany}));
  }

  onSelectPage(selectPage: number): void {
    this.store.dispatch(new FetchDisplayPageActual({pageActual: selectPage}));
  }

  onSelectSearchText(searchText: string): void {
    this.store.dispatch(new FetchDisplaySearchText({searchText}));
  }

  onInputSearchText(text: string): void {
    this.searchSubject.next(text);
  }
}






//
// @Select(EmployeesState.getDisplayEmployeeCompany)
// displayCompany$: Observable<string>;
//
// @Select(EmployeesState.getDisplayEmployeeStatus)
// displayStatus$: Observable<string>;
//
// @Select(EmployeesState.getDisplayPageMax)
// displayPageMax$: Observable<number>;
//
// @Select(EmployeesState.getDisplayPageActual)
// displayPageActual$: Observable<number>;
