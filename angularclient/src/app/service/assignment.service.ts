import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Assignment } from '../model/assignment';

@Injectable({
  providedIn: 'root'
})
export class AssignmentService {

  constructor(private http: HttpClient) { }

  public addAssignment(assignment: Assignment): void {
    this.http.post("http://localhost:8080/teacher/addAssignment", assignment);
  }
}
