import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { IUser } from '../shared/interfaces';

const apiUrl = environment.apiUrl;

@Injectable()
export class BandService {

  constructor(private http: HttpClient) { }

  loadBandList(): Observable<IUser[]> {
    return this.http.get<IUser[]>(`${apiUrl}/users`, { withCredentials: true });
  }

  loadBand(id: string): Observable<IUser> {
    return this.http.get<IUser>(`${apiUrl}/user/${id}`, { withCredentials: true });
  }
}