import { TestBed, async } from '@angular/core/testing';
import { NgxsModule, Store } from '@ngxs/store';
import { EmployeesState} from './employees.state';

describe('Employees store', () => {
  let store: Store;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [NgxsModule.forRoot([EmployeesState])]
    }).compileComponents();
    store = TestBed.inject(Store);
  }));

  // it('should create an action and add an item', () => {
  //   const expected: EmployeesStateModel = {
  //     items: ['item-1']
  //   };
  //   store.dispatch(new EmployeesAction('item-1'));
  //   const actual = store.selectSnapshot(EmployeesState.getState);
  //   expect(actual).toEqual(expected);
  // });

});
