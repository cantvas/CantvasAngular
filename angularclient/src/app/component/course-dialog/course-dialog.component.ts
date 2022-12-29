import { AfterViewInit, Component, ElementRef, Inject, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";
import { Course } from "../../model/course";
import { FormBuilder, Validators, FormGroup } from "@angular/forms"
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { CourseService } from 'src/app/service/course.service';
// import { LoadingService } from '../loading/loading.service';

@Component({
  selector: 'app-course-dialog',
  templateUrl: './course-dialog.component.html',
  styleUrls: ['./course-dialog.component.css']
})
export class CourseDialogComponent implements AfterViewInit {

  form: FormGroup;

    course: Course;

    constructor(
        private fb: FormBuilder,
        private dialogRef: MatDialogRef<CourseDialogComponent>,
        @Inject(MAT_DIALOG_DATA) course: Course,
        private coursesService: CourseService) {

        this.course = course;

        this.form = fb.group({
            description: [course.name, Validators.required],
        });
        
    }

    ngAfterViewInit() {

    }

    save() {

        const changes = this.form.value;
        const saveCourse$ = this.coursesService.add(this.course);

    }

    close() {
        this.dialogRef.close();
    }

}
