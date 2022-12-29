package com.CantvasAngular.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.CantvasAngular.CantvasAngular.Models.Assignment;
import com.CantvasAngular.CantvasAngular.Repository.AssignmentRepository;

public abstract class AssignmentService {
    @Autowired
    AssignmentRepository assignmentRepository;

    abstract void addAssignment(Assignment assignment);
    abstract void modifyAssignment(Long id);
}
