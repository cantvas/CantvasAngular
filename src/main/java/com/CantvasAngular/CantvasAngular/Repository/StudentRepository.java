package com.CantvasAngular.CantvasAngular.Repository;

import com.CantvasAngular.CantvasAngular.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Query(value = """
                insert into student_assignment
            (student_id, assignment_id) values
                    (:student_id, :assignment_id)
                    """, nativeQuery = true)
    void insertAssignment(@Param("student_id") Long studentId, @Param("assignment_id") Long id);
}
