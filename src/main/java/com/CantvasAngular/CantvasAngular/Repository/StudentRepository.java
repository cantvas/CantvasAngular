package com.CantvasAngular.CantvasAngular.Repository;

import com.CantvasAngular.CantvasAngular.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
