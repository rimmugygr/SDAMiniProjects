import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PAGE_MODE, PageForm} from '../../../shared/model/pageForm.model';
import {getPageModel} from '../../../shared/util/getPageModel';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Actions, ofActionSuccessful, Select, Store} from '@ngxs/store';
import {EmployeesState} from '../../../shared/state/employees/employees.state';
import {Employee, EmployeeStatus} from '../../../shared/model/employee.model';
import {AddEmployee, FetchEditEmployee} from '../../../shared/state/employees/employees.actions';
import {Observable} from 'rxjs';
import {map, shareReplay, tap} from 'rxjs/operators';

@Component({
  selector: 'app-employees-form',
  templateUrl: './employees-form.component.html',
  styleUrls: ['./employees-form.component.css']
})
export class EmployeesFormComponent implements OnInit {
  pageModel: PageForm;
  employeeForm: FormGroup;
  currentEmployee: Employee;
  employeesStatusEnum = EmployeeStatus;
  isError = false;
  isSuccessAction = true;

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
    this.action.pipe(ofActionSuccessful(AddEmployee)).subscribe(
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
      address: this.fb.group({
        street: [null, Validators.required],
        buildingNumber: [null],
        flatNumber: [null],
        city: [null, Validators.required],
        postalCode: [null, Validators.required],
        country: [null, Validators.required],
      })
    });

    if (this.isEditMode() || this.isDetailsMode()) {
      this.currentEmployee = this.store.selectSnapshot(EmployeesState.getEmployeeById)(this.pageModel.id);
      this.employeeForm.patchValue(this.currentEmployee);
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
    const employee  = { ... this.employeeForm.value };
    if (this.isCreateMode()) {
      // todo by selector not by action subscribe
      this.store.dispatch(new AddEmployee({employee}))
        .subscribe(() => this.addedEmployees$.subscribe(
            tab => this.router.navigateByUrl(`/employees/${tab[0].id}`)),
          error => this.isError = true,
          () => this.isError = false
        );
    }
    if (this.isEditMode()) {
      this.store.dispatch(new FetchEditEmployee({employee}));
      this.router.navigateByUrl(`/employees/${employee.id}`);
    }
  }

  ifRequired(value: string): boolean {
    return this.employeeForm.get(value).errors?.required && (this.employeeForm.get(value).touched || this.employeeForm.get(value).dirty );
  }
}
