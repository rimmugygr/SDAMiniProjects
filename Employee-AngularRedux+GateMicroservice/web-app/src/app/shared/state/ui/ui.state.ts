import { State, Action, Selector, StateContext } from '@ngxs/store';
import {IAlert} from '../../model/model';
import {SetAlertError, SetAlertSuccess} from './ui.actions';


export interface UiStateModel {
  alertSuccess: IAlert;
  alertError: IAlert;
}

@State<UiStateModel>({
  name: 'ui',
  defaults: {
    alertSuccess: { show: false },
    alertError: { show: false }
  }
})
export class UiState {

  @Selector()
  public static getSuccessAlert(state: UiStateModel): IAlert {
    return state.alertSuccess;
  }

  @Selector()
  public static getErrorAlert(state: UiStateModel): IAlert {
    return state.alertError;
  }

  @Action(SetAlertSuccess)
  public setSuccessAlert(ctx: StateContext<UiStateModel>, { payload }: SetAlertSuccess): any {
    ctx.patchState({ alertSuccess: payload.alertSuccess });
  }

  @Action(SetAlertError)
  public setErrorAlert(ctx: StateContext<UiStateModel>, { payload }: SetAlertError): any {
    ctx.patchState({ alertError: payload.alertError });
  }

}
