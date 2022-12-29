package com.CantvasAngular.CantvasAngular.Controllers;

import com.CantvasAngular.CantvasAngular.Models.Assignment;
import com.CantvasAngular.CantvasAngular.Repository.AssignmentRepository;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin("http://localhost:4200")
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

    @GetMapping("assignment/{id}")
    public Assignment getOneAssignment(@PathVariable Long id){
        return assignmentRepository.findById(id).orElse(null);
    }

}
