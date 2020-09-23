export interface Employee {
  id: string;
  firstName: string;
  lastName: string;
  dateOfBirth: string;
  phoneNumber: string;
  email: string;
  company: string;
  status: EmployeeStatus;
  address: Address;
  lastModifiedDate: string;
}

export interface Address {
  street: string;
  buildingNumber: string;
  flatNumber: string;
  city: string;
  postalCode: string;
  country: string;
}

// export interface DisplayEmployeesPage {
//   status: string;
//   pageActual: number;
//   pageMax: number;
//   pageSize: number;
// }

// export class DisplayEmployeesPage implements DisplayEmployeesPage{
//   status = '';
//   pageActual = 0;
//   pageMax = 0;
//   pageSize = 8;
//
// }

export enum EmployeeStatus {
  ACTIVE = 'ACTIVE',
  SUSPENDED = 'SUSPENDED',
  ON_SICK_LEAVE = 'ON_SICK_LEAVE',
  DISMISSED = 'DISMISSED',
}
