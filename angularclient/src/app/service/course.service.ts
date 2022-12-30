import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, shareReplay } from "rxjs";
import { Course } from "../model/course";

@Injectable({
  providedIn: "root",
})
export class CourseService {
  url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/courses";
  }
  public findAll(): Observable<Course[]> {
    return this.http.get<Course[]>(this.url);
  }

  public findOne(id: number): Observable<Course> {
    return this.http.get<Course>(this.url + "/" + id);
  }

  public add(course: Course): void {
    this.http.post("http://localhost:8080/course", course).subscribe(data => console.log(data));
  }

  public update(courseId: number, course: Partial<Course>): Observable<any> {
    return this.http.put(`http://localhost:8080/courses/${courseId}`, course)
    .pipe(
      shareReplay()
    );
  }
}
