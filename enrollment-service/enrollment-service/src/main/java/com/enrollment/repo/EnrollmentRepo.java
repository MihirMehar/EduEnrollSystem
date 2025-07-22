package com.enrollment.repo;

import com.enrollment.document.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepo extends JpaRepository<Enrollment,Long> {

    List<Enrollment> findByStudentId(Long studentId);
}
