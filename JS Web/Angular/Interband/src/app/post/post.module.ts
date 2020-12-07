import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostListComponent } from './post-list/post-list.component';
import { PostService } from './post.service';
import { PostListItemComponent } from './post-list-item/post-list-item.component';
import { NewPostComponent } from './new-post/new-post.component';
import { SharedModule } from '../shared/shared.module';
import { FormsModule } from '@angular/forms';
import { PostRouterModule } from './post-routing.module';

@NgModule({
  declarations: [
    PostListComponent,
    PostListItemComponent,
    NewPostComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    FormsModule,
    PostRouterModule
  ],
  providers: [
    PostService
  ],
  exports: [
    PostListComponent,
    PostListItemComponent
  ]
})
  
export class PostModule { }
