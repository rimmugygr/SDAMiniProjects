import { TestBed, async } from '@angular/core/testing';
import { NgxsModule, Store } from '@ngxs/store';
import { UiState, UiStateModel } from './ui.state';
import { UiAction } from './ui.actions';

describe('Ui store', () => {
  let store: Store;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [NgxsModule.forRoot([UiState])]
    }).compileComponents();
    store = TestBed.get(Store);
  }));

  it('should create an action and add an item', () => {
    const expected: UiStateModel = {
      items: ['item-1']
    };
    store.dispatch(new UiAction('item-1'));
    const actual = store.selectSnapshot(UiState.getState);
    expect(actual).toEqual(expected);
  });

});
