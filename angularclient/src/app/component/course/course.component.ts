import { Component, OnInit } from '@angular/core';
import { Observable, pipe } from 'rxjs';
import { Course } from 'src/app/model/course';
import { CourseService } from 'src/app/service/course.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
  constructor(private coursesService: CourseService){

  }

  loadCourses():Observable<Course[]> {
    return this.coursesService.findAll();
  }

  ngOnInit():void{
    this.loadCourses().subscribe(x => console.log(x));
  }
}
