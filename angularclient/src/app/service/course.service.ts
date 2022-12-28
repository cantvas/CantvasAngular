import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Course } from "../model/course";

@Injectable({
  providedIn: "root",
})
export class CourseService {
  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/api/course/courses";
  }
  public findAll(): Observable<Course[]> {
    return this.http.get<Course[]>(this.url);
  }
}
