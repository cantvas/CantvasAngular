import { Course } from "./course";

export class Student {
  id: number;
  name: string;
  email: string;
  course: number;

  constructor(id: number, name: string, email: string, course: number) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.course = course;
  }
}
