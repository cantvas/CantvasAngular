import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, of } from 'rxjs';
import { Assignment } from '../model/assignment';
import { Student } from '../model/student';

@Injectable({
  providedIn: "root",
})
export class StudentService {
  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/api/student";
  }

  public findAll(): Observable<Student[]> {
    return this.http.get<Student[]>(`${this.url}/students`);
  }

  public createStudent(student: Student): void {
    this.http.post(this.url, student);
  } 

  public getAverage(route: ActivatedRoute): Observable<number> {
    this.http.get(`${route.url}/get-average`)
      .subscribe(x => console.log(x));
    return of(null);
  }

  public getAssignments(route: ActivatedRoute): Assignment[] {
    this.http.get(`${route.url}/assignments`).subscribe(x => console.log(x));
    return [];
  }
}
