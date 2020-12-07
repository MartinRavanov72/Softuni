import { IBase } from './base';
import { IUser } from './user';

export interface IPost extends IBase {
  text: string;
  userId: IUser;
}