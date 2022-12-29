import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, pipe, map, tap } from 'rxjs';
import { Assignment } from 'src/app/model/assignment';
import { Course } from 'src/app/model/course';
import { AssignmentService } from 'src/app/service/assignment.service';
import { CourseService } from 'src/app/service/course.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  course: Course;
  assignments: Assignment[];

  constructor(
    private coursesService: CourseService,
    private assignmentService: AssignmentService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.pipe(
      map(data => data['courseId']),
      tap((id: number) => {
        this.loadCourseData(id).subscribe(data => this.course = data);
      })
    ).subscribe(data => data);
  }

  loadCourseData(id: number): Observable<Course> {
    return this.coursesService.findOne(id);
  }

  addAssignment(): void {
    let assignment: Assignment = new Assignment("test", "foobarbaz", 100);
    console.log("adding assignment");
    this.assignmentService.addAssignment(assignment);
    
  }
}
