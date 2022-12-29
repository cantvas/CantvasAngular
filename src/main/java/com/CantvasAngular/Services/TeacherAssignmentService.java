package com.CantvasAngular.Services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.CantvasAngular.CantvasAngular.Models.Assignment;

@Service
public class TeacherAssignmentService extends AssignmentService {

    @Override
    void addAssignment(Assignment assignment) {
        assignmentRepository.save(assignment);
    }

    @Override
    void modifyAssignment(Long id) {
        Optional<Assignment> assign = assignmentRepository.findById(id);
        
    }
}
