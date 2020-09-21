import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { faUserAlt } from '@fortawesome/free-solid-svg-icons';
import {Select} from '@ngxs/store';
import {DisplayEmployees, EmployeesState} from '../../shared/state/employees/employees.state';
import {Observable} from 'rxjs';
import {Employee} from '../../shared/model/employee.model';
import {map} from 'rxjs/operators';

interface NavigationItem {
  name: string;
  type: 'page' | 'action';
  url?: string;
}

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  icons = { faUserAlt };

  navItems: NavigationItem[] = [
    { name: 'Dashboard', type: 'page', url: 'dashboard' },
    { name: 'Timecards', type: 'page', url: 'timecards' },
    { name: 'Reports', type: 'page', url: 'reports' },
    { name: 'Send message', type: 'page', url: 'send-message' },
    { name: 'Support', type: 'action' },
  ];

  numberLastOperation = 3;

  @Select(EmployeesState.getRecentlyAddedEmployees)
  addEmployees$: Observable<Employee[]>;
  recentlyAddEmployees$: Observable<Employee[]> = this.addEmployees$.pipe(map(x => x.slice(0, this.numberLastOperation)));

  @Select(EmployeesState.getRecentlyEditedEmployees)
  editEmployees$: Observable<Employee[]>;
  recentlyEditedEmployees$: Observable<Employee[]> = this.editEmployees$.pipe(map(x => x.slice(0, this.numberLastOperation)));

  constructor() { }

  ngOnInit(): void {
  }

  isActive(item: NavigationItem): boolean {
    if (item.type === 'page' && item.name === 'Dashboard') {
      return true;
    }

    return false;
  }

  goToEmployees(): void {
  }
}
