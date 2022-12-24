package com.CantvasAngular.CantvasAngular.Controllers;

import com.CantvasAngular.CantvasAngular.Models.Course;
import com.CantvasAngular.CantvasAngular.Models.Student;
import com.CantvasAngular.CantvasAngular.Models.Teacher;
import com.CantvasAngular.CantvasAngular.Repository.CourseRepository;
import com.CantvasAngular.CantvasAngular.Repository.TeacherRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @PostMapping("/teacher")
    public int createTeacher() {
        Course course = courseRepository.getById(1L);
        Teacher s = new Teacher("Ian", "Ianlieberman93@gmail.com", course);
        teacherRepository.save(s);
        return Response.SC_OK;
    }
}
