package com.CantvasAngular.CantvasAngular.Repository;

import com.CantvasAngular.CantvasAngular.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Override
    Course getById(Long id);

    @Modifying
    @Query(value = "update Course c set c.name = :course.name where :id = :courseId", nativeQuery = true)
    void updateCourse(@Param("course") Course course, @Param("courseId") Long courseId);
}