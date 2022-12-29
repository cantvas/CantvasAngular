import { HttpClient, HttpStatusCode } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';
import { Assignment } from '../model/assignment';
import { Teacher } from '../model/teacher';

@Injectable({
  providedIn: "root",
})
export class TeacherService {
  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/api/teacher";
  }

  public findAll(): Observable<Teacher[]> {
    return this.http.get<Teacher[]>(`${this.url}/teachers`);
  }

  public addTeacher(teacher: Teacher): void {
    this.http.post(this.url, teacher);
  }

  public updateAssigment(assignment: Assignment): HttpStatusCode {
    this.http.put(`${this.url}/updateAssignment`, assignment)
      .pipe(
        catchError(e => of(null))
      );
    return HttpStatusCode.NoContent;
  }
}
