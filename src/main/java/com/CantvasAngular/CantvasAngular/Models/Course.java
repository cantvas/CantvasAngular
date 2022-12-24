package com.CantvasAngular.CantvasAngular.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
//    private Assignment assignment;
    @JsonManagedReference
    @OneToMany(mappedBy = "course")
    private List<Teacher> teachersList;

    @JsonManagedReference
    @OneToMany(mappedBy = "course")
    private List<Student> studentsList;
//    @OneToMany
//    @JoinColumn(name="assignment")
//    private List<Assignment> assignmentList;

    public Course(){}

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachersList() {
        return teachersList;
    }

    public void setTeachersList(List<Teacher> teachersList) {
        this.teachersList = teachersList;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

//    public List<Assignment> getAssignmentList() {
//        return assignmentList;
//    }
//
//    public void setAssignmentList(List<Assignment> assignmentList) {
//        this.assignmentList = assignmentList;
//    }
}
