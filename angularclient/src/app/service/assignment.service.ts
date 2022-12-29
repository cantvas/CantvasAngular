import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Assignment } from '../model/assignment';

@Injectable({
  providedIn: 'root'
})
export class AssignmentService {

  constructor(private http: HttpClient) { }

  public addAssignment(assignment: Assignment): void {
    this.http.post("http://localhost:8080/teacher/addAssignment", assignment);
  }

  public getAllAssignments(): Observable<Assignment[]>{
    
    let allAssignments = this.http.get<Assignment[]>("http://localhost:8080/assignments");
    allAssignments.subscribe(data => console.log(data));
    return allAssignments;
  }

  public findOne(id: number): Observable<Assignment>{
    return this.http.get<Assignment>(`http://localhost:8080/assignment/${id}`);
  }
}
