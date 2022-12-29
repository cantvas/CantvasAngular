import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Assignment } from 'src/app/model/assignment';
import { AssignmentService } from 'src/app/service/assignment.service';

@Component({
  selector: 'app-assignments',
  templateUrl: './assignments.component.html',
  styleUrls: ['./assignments.component.css']
})
export class AssignmentsComponent implements OnInit {
  ngOnInit(): void {
    this.loadAssignments();
  };
  assignments: Assignment[];

  constructor(private assignmentService: AssignmentService){}

  loadAssignments(){
    this.assignmentService.getAllAssignments().subscribe(data => this.assignments = data);
  }

  gotoAssignment(id: number){
    
  }
}
