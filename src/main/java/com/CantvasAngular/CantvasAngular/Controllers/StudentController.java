package com.CantvasAngular.CantvasAngular.Controllers;

import com.CantvasAngular.CantvasAngular.Models.Assignment;
import com.CantvasAngular.CantvasAngular.Models.Course;
import com.CantvasAngular.CantvasAngular.Models.Student;
import com.CantvasAngular.CantvasAngular.Repository.AssignmentRepository;
import com.CantvasAngular.CantvasAngular.Repository.CourseRepository;
import com.CantvasAngular.CantvasAngular.Repository.StudentRepository;
import com.CantvasAngular.Services.GradesService;

import org.apache.catalina.connector.Response;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    AssignmentRepository assignmentRepository;

    private final GradesService gradesService = new GradesService();

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/student")
    public HttpStatus createStudent(@RequestBody Student student) {
        Student s;
        if (student.getCourse() != null) {
            Course course = courseRepository.getById(student.getCourse().getId());
            if (course != null) {
                s = new Student(student.name, student.email, course);
                studentRepository.save(s);
            } 
        } else {
            s = new Student(student.name, student.email);
            studentRepository.save(s);
        }
        return HttpStatus.OK;
    }

    @GetMapping("{id}/get-average")
    public double getAverage(@PathVariable Long id) {
        Student student = studentRepository.getReferenceById(id);
        if (student != null) {
            List<Assignment> assignments = assignmentRepository.findByStudentId(id);
            return gradesService.calculateAverage(assignments, student);
        } else return 0.0;
    }

    @PostMapping("/dummy-student")
    public HttpStatus addDumy(){
        Student dummy = new Student("I did it!", "takethat@getrekt.com");
        studentRepository.save(dummy);
        return HttpStatus.OK;
    }
}
