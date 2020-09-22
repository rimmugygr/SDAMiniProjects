import {IAlert} from '../../model/model';

export class SetAlertSuccess {
  public static readonly type = '[UI] Set success alert';
  constructor(public payload: { alertSuccess: IAlert }) { }
}
export class SetAlertError {
  public static readonly type = '[UI] Set error alert';
  constructor(public payload: { alertError: IAlert }) { }
}

