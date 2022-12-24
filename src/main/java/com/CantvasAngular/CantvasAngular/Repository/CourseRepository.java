package com.CantvasAngular.CantvasAngular.Repository;

import com.CantvasAngular.CantvasAngular.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Override
    Course getById(Long id);
}