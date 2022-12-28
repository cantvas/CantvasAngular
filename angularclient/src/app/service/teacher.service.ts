import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Teacher } from '../model/teacher';

@Injectable({
  providedIn: "root",
})
export class TeacherService {
  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/api/teacher/teachers";
  }

  public findAll(): Observable<Teacher[]> {
    return this.http.get<Teacher[]>(this.url);
  }
}
