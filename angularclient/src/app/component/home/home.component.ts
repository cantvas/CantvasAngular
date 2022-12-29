import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from 'src/app/model/course';
import { CourseService } from 'src/app/service/course.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  courses: Course[] = [];


  constructor(private coursesService: CourseService) {

  }

  ngOnInit() {
    this.reloadCourses();


  }

  addCourse(course: Course): void {
    this.coursesService.add(course);
  }

  reloadCourses() {

    this.coursesService.findAll().subscribe(data => this.courses = data);

  }
}
