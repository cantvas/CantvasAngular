import { Course } from "./course"

export class Teacher {
  name: string
  email: string
  course: Course

  constructor(name: string, email: string, course: Course){
    this.name = name;
    this.email = email;
    this.course = course;
  }
}
