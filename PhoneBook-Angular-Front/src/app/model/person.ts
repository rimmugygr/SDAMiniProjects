import {IGender} from './gender';
import {IPhone} from './phone';

export interface IPerson {
  id: number;
  firstName: string;
  lastName: string;
  age: number;
  gender: IGender;
  phones: IPhone[];
}

