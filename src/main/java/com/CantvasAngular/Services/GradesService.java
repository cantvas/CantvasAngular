package com.CantvasAngular.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CantvasAngular.CantvasAngular.Models.Assignment;
import com.CantvasAngular.CantvasAngular.Models.Student;
import com.CantvasAngular.CantvasAngular.Repository.AssignmentRepository;
import com.CantvasAngular.CantvasAngular.Repository.StudentRepository;

@Service
public class GradesService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AssignmentRepository assignmentRepository;

    public double calculateAverage(List<Assignment> assigments, Student s) {
        return 0;
    }
}
