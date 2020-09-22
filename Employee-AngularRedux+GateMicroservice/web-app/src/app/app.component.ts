import { Component } from '@angular/core';
import {UiState} from './shared/state/ui/ui.state';
import {Observable} from 'rxjs';
import {IAlert} from './shared/model/model';
import {Select, Store} from '@ngxs/store';
import {SetAlertError, SetAlertSuccess} from './shared/state/ui/ui.actions';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @Select(UiState.getSuccessAlert) successAlert$: Observable<IAlert>;
  @Select(UiState.getErrorAlert) errorAlert$: Observable<IAlert>;

  constructor(private store: Store) {
  }

  hideSuccessAlert(): void {
    this.store.dispatch(new SetAlertSuccess({ alertSuccess: { show: false } }));
  }

  hideErrorAlert(): void {
    this.store.dispatch(new SetAlertError({ alertError: { show: false } }));
  }
}
