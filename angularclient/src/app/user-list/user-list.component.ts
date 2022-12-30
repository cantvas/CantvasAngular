import { Component, OnInit } from '@angular/core';
import { Course } from '../model/course';
import { Student } from '../model/student';
import { User } from '../model/user';
import { CourseService } from '../service/course.service';
import { StudentService } from '../service/student.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  students: Student[];
  courses: Course[];

  constructor(private studentService: StudentService, private courseService: CourseService) {
  }

  ngOnInit() {
    this.studentService.findAll().subscribe(data => {
      this.students = data;
    });
  }
}
