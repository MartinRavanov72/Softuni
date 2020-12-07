import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PostService } from '../post.service';

@Component({
  selector: 'app-new-post',
  templateUrl: './new-post.component.html',
  styleUrls: ['./new-post.component.css']
})
export class NewPostComponent implements OnInit {

  constructor(
    private postService: PostService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  submitHandler(data: any): void {
    this.postService.savePost(data)
      .subscribe({
        next: (data) => {
          this.router.navigate(['/post']);
        },
        error: (err) => {
          console.log(err);
        }
      });
  }
}
