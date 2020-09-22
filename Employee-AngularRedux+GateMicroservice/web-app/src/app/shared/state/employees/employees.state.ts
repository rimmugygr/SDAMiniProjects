import {State, Action, Selector, StateContext} from '@ngxs/store';
import {
  CreateEmployee,
  DisplayCompany,
  DisplayEmployees,
  DisplayPageActual,
  DisplaySearchText,
  DisplayStatus, UpdateEmployee,
  FetchEmployees
} from './employees.actions';
import {Employee} from '../../model/employee.model';
import {Injectable} from '@angular/core';
import {EmployeesService} from '../../services/employees.service';
import {tap} from 'rxjs/operators';

export interface EmployeesStateModel {
  employees: Employee[];
  companies: string[];
  display: DisplayEmployee;
  recentlyAddedEmployees: Employee[];
  recentlyDeletedEmployees: Employee[];
  recentlyEditedEmployees: Employee[];
}

export interface DisplayEmployee {
  displayEmployees: Employee[];
  displayStatus: string;
  displayCompany: string;
  displaySearchText: string;
  displayPageActual: number;
  displayPageMax: number;
  displayPageSize: number;
}

@State<EmployeesStateModel>({
  name: 'employees',
  defaults: {
    employees: [],
    companies: [],
    display: {
      displayEmployees: [],
      displayStatus: ``,
      displayCompany: ``,
      displaySearchText: ``,
      displayPageActual: 1,
      displayPageMax: 1,
      displayPageSize: 6,
    },
    recentlyAddedEmployees: [],
    recentlyDeletedEmployees: [],
    recentlyEditedEmployees: []
  }
})

@Injectable()
export class EmployeesState{
  @Selector()
  public static getDisplayEmployees(state: EmployeesStateModel): DisplayEmployee {
    return state.display;
  }

  @Selector()
  public static getCompanies(state: EmployeesStateModel): string[] {
    return state.companies;
  }

  @Selector()
  public static getEmployeeById(state: EmployeesStateModel): (id: string) => Employee {
    return (id: string): Employee => {
      return state.employees.find(employee => employee.id === id);
    };
  }

  @Selector()
  public static getAllEmployees(state: EmployeesStateModel): Employee[] {
    return state.employees;
  }

  @Selector()
  public static getRecentlyAddedEmployees(state: EmployeesStateModel): Employee[] {
    return state.recentlyAddedEmployees;
  }

  @Selector()
  public static getRecentlyEditedEmployees(state: EmployeesStateModel): Employee[] {
    return state.recentlyEditedEmployees;
  }

  @Selector()
  public static getRecentlyDeletedEmployees(state: EmployeesStateModel): Employee[] {
    return state.recentlyDeletedEmployees;
  }

  constructor(private employeesService: EmployeesService) {
  }

  @Action(FetchEmployees)
  public fetchEmployees(ctx: StateContext<EmployeesStateModel>): any {
    return this.employeesService.getEmployeesResponse().pipe(
      tap(data => {
        ctx.patchState({employees: data.content}); // ctx.setState(patch({employees: [] as EmployeeModel[]}));
        ctx.patchState({companies: this.employeesService.getAllCompanies(data.content)});
        ctx.dispatch(new DisplayEmployees());
      }),
    );
  }

  @Action(CreateEmployee)
  public fetchAddEmployee(ctx: StateContext<EmployeesStateModel>, action: CreateEmployee): any {
    return this.employeesService.postEmployee(action.payload.employee).pipe(
      tap(data => {
        const employees = [... ctx.getState().employees, data];
        ctx.patchState({recentlyAddedEmployees: [data, ...ctx.getState().recentlyAddedEmployees]});
        ctx.patchState({employees});
        ctx.patchState({companies: this.employeesService.getAllCompanies(employees)});
        ctx.dispatch(new DisplayEmployees());
      }),
    );
  }

  // todo check if last modified is on the same id
  @Action(UpdateEmployee)
  public fetchEditEmployee(ctx: StateContext<EmployeesStateModel>, action: UpdateEmployee): any {
    return this.employeesService.putEmployee(action.payload.employee).pipe(
      tap((data: Employee) => {
        const employees = [... ctx.getState().employees].map(x =>  x.id === data.id ? data : x);
        ctx.patchState({recentlyEditedEmployees: [data, ...ctx.getState().recentlyEditedEmployees]});
        ctx.patchState({employees});
        ctx.patchState({companies: this.employeesService.getAllCompanies(employees)});
        ctx.dispatch(new DisplayEmployees());
      }),
    );
  }

  @Action(DisplayStatus)
  public fetchDisplayEmployeeStatus(ctx: StateContext<EmployeesStateModel>, action: DisplayStatus): void {
    ctx.patchState( {display: { ... ctx.getState().display, displayStatus: action.payload.status} });
    ctx.dispatch(new DisplayPageActual({pageActual: 1}));
  }

  @Action(DisplayCompany)
  public fetchDisplayEmployeeCompany(ctx: StateContext<EmployeesStateModel>, action: DisplayCompany): void {
    ctx.patchState( {display: { ... ctx.getState().display, displayCompany: action.payload.company} });
    ctx.dispatch(new DisplayPageActual({pageActual: 1}));
  }

  @Action(DisplaySearchText)
  public fetchDisplaySearchText(ctx: StateContext<EmployeesStateModel>, action: DisplaySearchText): void {
    ctx.patchState( {display: { ... ctx.getState().display, displaySearchText: action.payload.searchText} });
    ctx.dispatch(new DisplayPageActual({pageActual: 1}));
  }

  @Action(DisplayPageActual)
  public fetchDisplayPageActual(ctx: StateContext<EmployeesStateModel>, action: DisplayPageActual): void {
    ctx.patchState( {display: { ... ctx.getState().display, displayPageActual: action.payload.pageActual} });
    ctx.dispatch(new DisplayEmployees());
  }

  @Action(DisplayEmployees)
  public displayEmployees(ctx: StateContext<EmployeesStateModel>): void {
    const display = this.employeesService.getDisplayEmployees(ctx.getState().display, ctx.getState().employees);
    ctx.patchState( {display: { ... ctx.getState().display, displayEmployees: display.employees} });
    ctx.patchState( {display: { ... ctx.getState().display, displayPageMax: display.pageMax} });
  }
}








// @Selector()
// public static getDisplayEmployees(state: EmployeesStateModel): Employee[] {
//   return state.displayEmployees;
// }
//
// @Selector()
// public static getDisplayEmployeeStatus(state: EmployeesStateModel): string {
//   return state.displayStatus;
// }
//
// @Selector()
// public static getDisplayEmployeeCompany(state: EmployeesStateModel): string {
//   return state.displayCompany;
// }
//
// @Selector()
// public static getDisplayPageMax(state: EmployeesStateModel): number {
//   return state.displayPageMax;
// }
//
// @Selector()
// public static getDisplayPageActual(state: EmployeesStateModel): number {
//   return state.displayPageActual;
// }
// @Action(FetchDisplayEmployees)
// public fetchDisplayEmployees(ctx: StateContext<EmployeesStateModel>): void {
//   const display = this.employeesService.getDisplayEmployees(
//     ctx.getState().displayStatus,
//     ctx.getState().displaySearchText,
//     ctx.getState().displayCompany,
//     ctx.getState().displayPageActual,
//     ctx.getState().displayPageSize,
//     ctx.getState().employees);
//   ctx.patchState( { displayEmployees: display.employees});
//   ctx.patchState({ displayPageMax: display.pageMax});
// }
//
