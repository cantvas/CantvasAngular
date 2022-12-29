package com.CantvasAngular.CantvasAngular.Controllers;

import com.CantvasAngular.CantvasAngular.Models.Assignment;
import com.CantvasAngular.CantvasAngular.Repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssignmentController {
    @Autowired
    AssignmentRepository assignmentRepository;

    @GetMapping("/assignments")
    public List<Assignment> getAssignments(){
        List<Assignment> assignmentList = assignmentRepository.findAll();
        return assignmentList;
    }

    @GetMapping("/{id}/assignments")
    public List<Assignment> getAssignmentsForStudent(@PathVariable Long id) {
        return assignmentRepository.findByStudentId(id);
    }
}
