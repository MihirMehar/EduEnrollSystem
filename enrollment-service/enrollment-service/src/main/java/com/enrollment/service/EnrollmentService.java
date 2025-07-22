package com.enrollment.service;

import com.enrollment.document.EnrollmentDTO;

import java.util.List;

public interface EnrollmentService {

    EnrollmentDTO createEnrollment(EnrollmentDTO enrollmentDTO);

    List<EnrollmentDTO> getEnrollmentsByStudentId(Long studentId);
}
