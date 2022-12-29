package com.CantvasAngular.CantvasAngular.Controllers;

import com.CantvasAngular.CantvasAngular.Models.Assignment;
import com.CantvasAngular.CantvasAngular.Models.Course;
import com.CantvasAngular.CantvasAngular.Models.Teacher;
import com.CantvasAngular.CantvasAngular.Repository.AssignmentRepository;
import com.CantvasAngular.CantvasAngular.Repository.CourseRepository;
import com.CantvasAngular.CantvasAngular.Repository.TeacherRepository;
import com.CantvasAngular.Services.TeacherAssignmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    AssignmentRepository assignmentRepository;

    private final TeacherAssignmentService teacherAssignmentService = new TeacherAssignmentService();

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @PostMapping("/teacher")
    public HttpStatus createTeacher(@RequestBody Teacher teacher) {
        Teacher s;
        Course course = courseRepository.getById(teacher.getCourse().getId());
        if (course != null) {
            s = new Teacher(teacher.name, teacher.email, course);
        } else
            s = new Teacher(teacher.name, teacher.email);
        teacherRepository.save(s);
        return HttpStatus.CREATED;
    }

    @PostMapping("/teacher/addAssignment")
    public HttpStatus addAssignment(@RequestBody Assignment assignment) {
        assignmentRepository.save(assignment);
        return HttpStatus.CREATED;
    }

    @PutMapping("/teacher/update")
    public HttpStatus updateAssignment(@RequestBody Assignment assignment) {
        Assignment toBeChanged = assignmentRepository.findById(assignment.getId())
                .flatMap((Assignment a) -> {
                    a.setName(assignment.getName());
                    a.setDocument(assignment.getDocument());
                    return Optional.of(a);
                }).orElseThrow();
        assignmentRepository.save(toBeChanged);
        return HttpStatus.NO_CONTENT;
    }
}
