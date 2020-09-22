import { Injectable } from '@angular/core';
import {Actions, ofActionDispatched, ofActionErrored, ofActionSuccessful, Store} from '@ngxs/store';
import {CreateEmployee} from '../state/employees/employees.actions';
import {SetAlertError, SetAlertSuccess} from '../state/ui/ui.actions';
import {interval} from 'rxjs';
import {take} from 'rxjs/operators';
import {UiState} from '../state/ui/ui.state';

@Injectable({
  providedIn: 'root'
})
export class AlertHandler {

  constructor(
    private actions$: Actions,
    private store: Store,
  ) {
    this.actions$
      .pipe(ofActionSuccessful(CreateEmployee))
      .subscribe(result => {
        this.store.dispatch(new SetAlertSuccess({
          alertSuccess: {
            show: true, text: 'Employee created!', length: 5 * 1000
          }
        }));
      });

    this.actions$
      .pipe(ofActionErrored(CreateEmployee))
      .subscribe(result => {
        this.store.dispatch(new SetAlertError({
          alertError: {
            show: true, text: 'Employee not created! Error occurred!', length: 5 * 1000
          }
        }));
      });

    this.actions$
      .pipe(ofActionDispatched(SetAlertSuccess))
      .subscribe((alertChange: SetAlertSuccess) => {
        if (alertChange.payload.alertSuccess.show) {
          interval(alertChange.payload.alertSuccess.length).pipe(take(1)).subscribe(() => {
            const currentSuccessAlert = this.store.selectSnapshot(UiState.getSuccessAlert);
            if (currentSuccessAlert.show) {
              this.store.dispatch(new SetAlertSuccess({ alertSuccess: { show: false } }));
            }
          });
        }
      });

    this.actions$
      .pipe(ofActionDispatched(SetAlertError))
      .subscribe((alertChange: SetAlertError) => {
        if (alertChange.payload.alertError.show) {
          interval(alertChange.payload.alertError.length).pipe(take(1)).subscribe(() => {
            const currentErrorAlert = this.store.selectSnapshot(UiState.getErrorAlert);
            if (currentErrorAlert.show) {
              this.store.dispatch(new SetAlertError({ alertError: { show: false } }));
            }
          });
        }
      });
  }
}
