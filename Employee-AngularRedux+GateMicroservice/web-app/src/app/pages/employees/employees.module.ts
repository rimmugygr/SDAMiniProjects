import { NgModule } from '@angular/core';
import { EmployeesRoutingModule } from './employees-routing.module';
import { EmployeesComponent } from './employees.component';
import { EmployeesFormComponent } from './employees-form/employees-form.component';
import {SharedModule} from '../../shared/shared.module';


@NgModule({
  declarations: [EmployeesComponent, EmployeesFormComponent],
  imports: [
    EmployeesRoutingModule,
    SharedModule,
  ]
})
export class EmployeesModule { }
