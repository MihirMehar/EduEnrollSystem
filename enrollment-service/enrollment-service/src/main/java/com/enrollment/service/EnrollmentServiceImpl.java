package com.enrollment.service;

import com.enrollment.document.Enrollment;
import com.enrollment.document.EnrollmentDTO;
import com.enrollment.repo.EnrollmentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public EnrollmentDTO createEnrollment(EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = modelMapper.map(enrollmentDTO,Enrollment.class);
        enrollmentRepo.save(enrollment);
        return modelMapper.map(enrollment,EnrollmentDTO.class);
    }

    @Override
    public List<EnrollmentDTO> getEnrollmentsByStudentId(Long studentId) {
        List<Enrollment> enrollments = enrollmentRepo.findByStudentId(studentId);
        List<EnrollmentDTO> dtos = enrollments.stream().map(e -> modelMapper.map(e,EnrollmentDTO.class)).collect(Collectors.toList());
        return dtos;
    }
}
