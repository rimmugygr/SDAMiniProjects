import {Employee} from '../../model/employee.model';

export class FetchEmployees {
  public static readonly type = '[Employees] Fetch all employees and companies';
}

export class FetchDisplayEmployees {
  public static readonly type = '[Employees] Fetch display employee';
}

export class FetchDisplayStatus {
  public static readonly type = '[Employees] Fetch display status';
  constructor(public payload: {status: string}) { }
}

export class FetchDisplayCompany {
  public static readonly type = '[Employees] Fetch display company';
  constructor(public payload: {company: string}) { }
}

export class FetchDisplaySearchText {
  public static readonly type = '[Employees] Fetch display search text';
  constructor(public payload: {searchText: string}) { }
}

export class FetchDisplayPageActual {
  public static readonly type = '[Employees] Fetch display actual page';
  constructor(public payload: {pageActual: number}) { }
}

export class AddEmployee {
  public static readonly type = '[Employees] Fetch add employee';
  constructor(public payload: {employee: Employee}) { }
}

export class FetchEditEmployee {
  public static readonly type = '[Employees] Fetch edit employee';
  constructor(public payload: {employee: Employee}) { }
}

export class FetchDeleteEmployee {
  public static readonly type = '[Employees] Fetch delete employee';
  constructor(public payload: {id: string}) { }
}

export class FetchEmployeeById {
  public static readonly type = '[Employees] Fetch employee by id';
  constructor(public payload: {id: string}) { }
}
