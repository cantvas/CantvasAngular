package com.CantvasAngular.CantvasAngular.Repository;

import com.CantvasAngular.CantvasAngular.Models.Course;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Override
    Course getById(Long id);

    @Transactional
    @Modifying
    @Query(value = "update Course c set c.name = :name where c.id = :courseId")
    void updateCourse(@Param("name") String courseName, Course course, @Param("courseId") Long courseId);
}