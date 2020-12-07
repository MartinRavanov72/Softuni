import { IBase } from './base';
import { IPost } from './post';

export interface IUser extends IBase {
  email: string;
  name: string;
  password: string;
  imgUrl: string;
  genre: string;
  posts: IPost[];
}