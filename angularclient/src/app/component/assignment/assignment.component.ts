import { Component } from '@angular/core';
import { Assignment } from 'src/app/model/assignment';
import { Observable, map, tap } from "rxjs";
import { ActivatedRoute } from '@angular/router';
import { AssignmentService } from 'src/app/service/assignment.service';

@Component({
  selector: "app-assignment",
  templateUrl: "./assignment.component.html",
  styleUrls: ["./assignment.component.css"],
})
export class AssignmentComponent {
  assignment: Assignment;
  constructor(private route: ActivatedRoute, private assignmentService: AssignmentService) {}

  ngOnInit(): void {
    this.route.params
      .pipe(
        map((data) => data["id"]),
        tap((id: number) => {
          this.loadAssignmentData(id).subscribe((data) => (this.assignment = data));
        })
      )
      .subscribe((data) => data);
  }

  loadAssignmentData(id: number): Observable<Assignment> {
    return this.assignmentService.findOne(id);
  }
}
