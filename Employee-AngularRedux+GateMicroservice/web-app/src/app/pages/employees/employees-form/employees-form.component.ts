import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PAGE_MODE, PageForm} from '../../../shared/model/model';
import {getPageModel} from '../../../shared/util/getPageModel';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Actions, ofActionSuccessful, Select, Store} from '@ngxs/store';
import {EmployeesState} from '../../../shared/state/employees/employees.state';
import {Employee, EmployeeStatus} from '../../../shared/model/employee.model';
import {CreateEmployee, UpdateEmployee} from '../../../shared/state/employees/employees.actions';
import {Observable} from 'rxjs';
import {map, tap} from 'rxjs/operators';

@Component({
  selector: 'app-employees-form',
  templateUrl: './employees-form.component.html',
  styleUrls: ['./employees-form.component.css']
})
export class EmployeesFormComponent implements OnInit {
  pageModel: PageForm;
  employeeForm: FormGroup;
  currentEmployee: Employee;
  showError = false;
  isSuccessAction = true;
  statusMap: Record<string, string> = {...EmployeeStatus};

  employee$: Observable<Employee>;

  @Select(EmployeesState.getRecentlyAddedEmployees)
  addedEmployees$: Observable<Employee[]>;

  @Select(EmployeesState.getRecentlyEditedEmployees)
  editedEmployees$: Observable<Employee[]>;




  constructor(private activatedRoute: ActivatedRoute,
              private fb: FormBuilder,
              private router: Router,
              private store: Store,
              private action: Actions) { }

  ngOnInit(): void {
    this.pageModel = getPageModel(this.activatedRoute);
    this.initForm();
    this.initStatus();
    this.action.pipe(ofActionSuccessful(CreateEmployee)).subscribe(
      result => this.isSuccessAction = true
    );

  }

  private initForm(): void {
    this.employeeForm = this.fb.group({
      id: [],
      firstName: [null, Validators.required],
      lastName: [null, Validators.required],
      dateOfBirth: [null, [Validators.required]],
      phoneNumber: [null, Validators.required],
      email: [null, Validators.required],
      status: [null, Validators.required],
      company: [null, Validators.required],
      street: [null, Validators.required],
      buildingNumber: [null],
      flatNumber: [null],
      city: [null, Validators.required],
      postalCode: [null, Validators.required],
      country: [null, Validators.required],
    });

    if (this.isEditMode() || this.isDetailsMode()) {
      this.currentEmployee = this.store.selectSnapshot(EmployeesState.getEmployeeById)(this.pageModel.id);
      this.employeeForm.patchValue(
        {
          ...this.currentEmployee,
          street: this.currentEmployee.address.street,
          buildingNumber: this.currentEmployee.address.buildingNumber,
          flatNumber: this.currentEmployee.address.flatNumber,
          city: this.currentEmployee.address.city,
          postalCode: this.currentEmployee.address.postalCode,
          country: this.currentEmployee.address.country
        });
    }

    if (this.isDetailsMode()) {
      this.employee$  = this.store.select(EmployeesState.getEmployeeById)
        .pipe(
          map(filterFn => filterFn(this.pageModel.id)),
          tap(employee => this.employeeForm.patchValue(employee))
        );
      this.employeeForm.disable();
    }
  }

  isEditMode(): boolean {
    return this.pageModel.pageMode === PAGE_MODE.EDIT;
  }

  isDetailsMode(): boolean {
    return this.pageModel.pageMode === PAGE_MODE.DETAILS;
  }

  isCreateMode(): boolean {
    return this.pageModel.pageMode === PAGE_MODE.CREATE;
  }

  onDeleted(): void {
  }

  onCancel(): string {
    if (this.isEditMode()) {
      return '/employees/' + this.pageModel.id;
    }
    if (this.isCreateMode()) {
      return '/employees';
    }
    if (this.isDetailsMode()) {
      return '/employees';
    }
  }
  onFormSubmit(): void {
    this.showError = true;
    const employee: Employee  = { ... this.employeeForm.value,
      address: {
      street: this.employeeForm.value.street,
      buildingNumber:  this.employeeForm.value.buildingNumber,
      flatNumber:  this.employeeForm.value.flatNumber,
      city:  this.employeeForm.value.city,
      postalCode:  this.employeeForm.value.postalCode,
      country:  this.employeeForm.value.country,
    }};
    if (this.isCreateMode()) {
      this.store.dispatch(new CreateEmployee({employee}));
    }
    if (this.isEditMode()) {
      this.store.dispatch(new UpdateEmployee({employee}));
    }
  }

  ifRequired(value: string): boolean {
    return this.employeeForm.get(value).errors?.required && (this.employeeForm.get(value).touched || this.employeeForm.get(value).dirty );
  }

  private initStatus(): void {
    this.statusMap = {...EmployeeStatus};
    for (const key of Object.keys(EmployeeStatus)) {
      this.statusMap[key] = this.toNormalText(this.statusMap[key]);
    }
  }

  private toNormalText(text: string): string {
    return text.slice(0, 1).toUpperCase() + text.slice(1).toLowerCase().split('_').join('\n');
  }


}
