import {Employee} from '../../model/employee.model';

export class FetchEmployees {
  public static readonly type = '[Employees] Fetch all employees and companies';
}

export class DisplayEmployees {
  public static readonly type = '[Employees] Display employee';
}

export class DisplayStatus {
  public static readonly type = '[Employees] Display status';
  constructor(public payload: {status: string}) { }
}

export class DisplayCompany {
  public static readonly type = '[Employees] Display company';
  constructor(public payload: {company: string}) { }
}

export class DisplaySearchText {
  public static readonly type = '[Employees] Display search text';
  constructor(public payload: {searchText: string}) { }
}

export class DisplayPageActual {
  public static readonly type = '[Employees] Display actual page';
  constructor(public payload: {pageActual: number}) { }
}

export class CreateEmployee {
  public static readonly type = '[Employees] Create employee';
  constructor(public payload: {employee: Employee}) { }
}

export class UpdateEmployee {
  public static readonly type = '[Employees] Update employee';
  constructor(public payload: {employee: Employee}) { }
}

export class DeleteEmployee {
  public static readonly type = '[Employees] Delete employee';
  constructor(public payload: {id: string}) { }
}

export class FetchEmployeeById {
  public static readonly type = '[Employees] Fetch employee by id';
  constructor(public payload: {id: string}) { }
}
