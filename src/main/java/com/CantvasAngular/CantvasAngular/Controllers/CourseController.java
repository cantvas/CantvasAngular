package com.CantvasAngular.CantvasAngular.Controllers;

import com.CantvasAngular.CantvasAngular.Models.Assignment;
import com.CantvasAngular.CantvasAngular.Models.Course;
import com.CantvasAngular.CantvasAngular.Models.Student;
import com.CantvasAngular.CantvasAngular.Models.Teacher;
import com.CantvasAngular.CantvasAngular.Repository.AssignmentRepository;
import com.CantvasAngular.CantvasAngular.Repository.CourseRepository;
import com.CantvasAngular.CantvasAngular.Repository.StudentRepository;
import com.CantvasAngular.CantvasAngular.Repository.TeacherRepository;
import org.apache.catalina.Session;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    @PostMapping("/course")
    public int addCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return Response.SC_OK;
    }

    @PostMapping("/coursefake")
    public int addCourseFake() {
        Course course = new Course("ben");
        Assignment assignment = new Assignment("Joe's chili", "lots of salt");
        Student joe = new Student("Joe", "Joe@bingbong.com");
        assignmentRepository.save(assignment);
        course.addToAssignmentList(assignment);
        joe.setCourse(course);
        courseRepository.save(course);
        return Response.SC_OK;
    }

    @PostMapping("/addAssignment")
    public int addAssignment(@RequestBody Assignment assignment){
        assignmentRepository.save(assignment);
        Course course = courseRepository.findById(1L).get();
        List<Student> studentList = course.getStudentsList();
        for (Student student: studentList){
            student.updateGrade(assignment, null);
        }
        course.addToAssignmentList(assignment);
        return Response.SC_OK;
    }

    @PostMapping("/addStudent")
    public int addStudent(@RequestBody Student student){
        studentRepository.save(student);
        Course course = courseRepository.findById(1L).get();
        student.setCourse(course);
        student.buildGradesMap();
        return Response.SC_OK;
    }

    @PostMapping("/addTeacher")
    public int addTeacher(@RequestBody Teacher teacher){
        teacherRepository.save(teacher);
        Course course = courseRepository.findById(1L).get();
        teacher.setCourse(course);
        return Response.SC_OK;
    }
}