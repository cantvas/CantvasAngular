import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { CourseComponent } from './component/course/course.component';
import { HomeComponent } from './component/home/home.component';
import { TeacherComponent } from './component/teacher/teacher.component';
import { AssignmentsComponent } from './component/assignments/assignments.component';
import { Assignment } from './model/assignment';
import { AssignmentComponent } from './component/assignment/assignment.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'users', component: UserListComponent },
  { path: 'adduser', component: UserFormComponent },
  { path: 'teacher', component: TeacherComponent },
  { path: 'courses', component: CourseComponent },
  { path: 'courses/:courseId', component: CourseComponent },
  { path: 'assignments', component: AssignmentsComponent},
  { path: 'assignment/:id', component: AssignmentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
