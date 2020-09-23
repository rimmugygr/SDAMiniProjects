import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from '../model/employee.model';
import {environment} from '../../../environments/environment';
import {Pageable} from '../model/pageable.model';
import {DisplayEmployee} from '../state/employees/employees.state';

const  headers = new HttpHeaders({ 'Content-Type': 'application/json'});

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {
  private host = environment.host;
  private employeeService = `${this.host}/api/v1/employees-service`;
  private baseEmployeesUrl = `${this.employeeService}/employees`;

  constructor(private http: HttpClient) { }

  getEmployeesResponse(): Observable<Pageable<Employee>> {
    return this.http.get<Pageable<Employee>>(this.baseEmployeesUrl);
  }

  postEmployee(employee: Employee): Observable<Employee> {
     return this.http.post<Employee>(this.baseEmployeesUrl, employee, {headers});
  }

  putEmployee(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${this.baseEmployeesUrl}/${employee.id}`, employee, {headers});
  }

  deleteEmployee(id: string): Observable<Employee> {
    return this.http.delete<Employee>(`${this.baseEmployeesUrl}/${id}`);
  }

  getDisplayEmployees(display: DisplayEmployee, employees: Employee []): {employees: Employee[], pageMax: number} {
     const employeesFiltered = this.getEmployeesFiltered(employees, display.displayStatus, display.displaySearchText, display.displayCompany);
     const displayPageMax = this.getDisplayPageMax(display.displayPageSize, employeesFiltered);
     const employeesPageableAndFiltered = this.getEmployeesPageable(employeesFiltered, display.displayPageActual, display.displayPageSize);
     return {pageMax: displayPageMax, employees: employeesPageableAndFiltered};
  }

  getAllCompanies(employees: Employee[]): string[] {
    return  Array.from(new Set(employees.map(x => x.company)));
  }

  private getEmployeesPageable(employeesFiltered: Employee[], pageActual: number, pageSize: number): Employee[] {
    return employeesFiltered.map((employee, i) => ({id: i + 1, ...employee}))
      .slice((pageActual - 1) * pageSize, (pageActual - 1) * pageSize + pageSize);
  }

  private getEmployeesFiltered(employees: Employee[], status: string, searchText: string, company: string): Employee[] {
    return employees
      .filter(employee => status !== `` ? employee.status === status : true)
      .filter(employee => company !== `` ? employee.company === company : true)
      .filter(employee => searchText !== `` ? this.isTextInName(employee, searchText) : true);
  }

  private isTextInName(employee: Employee, searchText: string): boolean {
    const searchTextLower = searchText?.toLowerCase();
    return employee.lastName?.toLowerCase().includes(searchTextLower) || employee.firstName?.toLowerCase().includes(searchTextLower);
  }

  private getDisplayPageMax(displayPageSize: number, employees: Employee[]): number {
    return Math.ceil(employees.length / displayPageSize );
  }
}











// employeesResponse$: Observable<Pageable<Employee>> = this.http.get<Pageable<Employee>>(this.baseEmployeesUrl);
// employeesFiltered$: Observable<Employee[]> = combineLatest([
//   this.employeeStatusSelectedAction$,
//   this.employees$
// ])
//   .pipe(
//     map(([employeeStatus, employees]) =>
//       employees.filter(employee => employeeStatus !== `` ? employee.status === employeeStatus : true)),
//     shareReplay(1)
//   );
