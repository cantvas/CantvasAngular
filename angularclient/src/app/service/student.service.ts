import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../model/student';

@Injectable({
  providedIn: "root",
})
export class StudentService {
  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/api/student/students";
  }

  public findAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.url);
  }
}
