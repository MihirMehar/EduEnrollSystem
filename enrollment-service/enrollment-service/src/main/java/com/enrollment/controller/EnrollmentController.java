package com.enrollment.controller;

import com.enrollment.document.EnrollmentDTO;
import com.enrollment.service.EnrollmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@Validated
public class EnrollmentController {

    @Autowired
    private EnrollmentServiceImpl enrollmentService;

    private static final Logger logger = LoggerFactory.getLogger(EnrollmentController.class);

    @PostMapping
    public ResponseEntity<EnrollmentDTO> createEnrollment( @Valid @RequestBody EnrollmentDTO enrollmentDTO) {
        logger.info("EnrollmentController:createEnrollment");
        return new ResponseEntity<>(enrollmentService.createEnrollment(enrollmentDTO),HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentByStudentId(@PathVariable Long studentId) {
        logger.info("Fetching enrollments by student id");
        return new ResponseEntity<>(enrollmentService.getEnrollmentsByStudentId(studentId), HttpStatus.OK);
    }

}
