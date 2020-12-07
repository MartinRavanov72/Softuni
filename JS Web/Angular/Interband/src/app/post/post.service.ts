import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { IPost } from '../shared/interfaces';

const apiUrl = environment.apiUrl;

@Injectable()
export class PostService {

  constructor(private http: HttpClient) { }

  loadPostList(): Observable<IPost[]> {
    return this.http.get<IPost[]>(`${apiUrl}/posts`, { withCredentials: true });
  }

  loadPost(id: string): Observable<IPost> {
    return this.http.get<IPost>(`${apiUrl}/posts/${id}`, { withCredentials: true });
  }

  savePost(data: any): Observable<IPost> {
    return this.http.post<IPost>(`${apiUrl}/posts`, data, { withCredentials: true });
  }
}