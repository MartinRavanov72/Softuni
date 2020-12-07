import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '../core/guards/auth-guard';
import { NewPostComponent } from './new-post/new-post.component';
import { PostListComponent } from './post-list/post-list.component';

const routes: Routes = [
  {
    path: 'post',
    canActivateChild: [AuthGuard],
    children: [
      {
        path: '',
        pathMatch: 'full',
        component: PostListComponent,
        data: {
          title: 'Posts',
          isLogged: true
        }
      },
      {
        path: 'new',
        component: NewPostComponent,
        data: {
          title: 'New Post',
          isLogged: true
        }
      }
    ]
  }
];

export const PostRouterModule = RouterModule.forChild(routes);