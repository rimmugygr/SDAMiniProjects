import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployeesComponent} from './employees.component';
import {NotFoundComponent} from '../not-found/not-found.component';
import {EmployeesFormComponent} from './employees-form/employees-form.component';

const routes: Routes = [
  { path: 'create', component: EmployeesFormComponent }, // /employees/create - create
  { path: 'edit', component: NotFoundComponent }, // /employees/create - create
  { path: 'edit/:id', component: EmployeesFormComponent }, // /employees/edit/{id} - edit
  { path: ':id', component: EmployeesFormComponent }, // /employees/{id} - view employee details
  { path: '', component: EmployeesComponent }, // /employees - list of all employees
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeesRoutingModule { }
