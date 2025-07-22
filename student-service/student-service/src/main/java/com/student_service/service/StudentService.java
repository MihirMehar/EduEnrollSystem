package com.student_service.service;

import com.student_service.document.StudentDTO;
import com.student_service.exception.StudentNotFound;

import java.util.List;

public interface StudentService {


    public StudentDTO createStudent(StudentDTO studentDTO);
    public List<StudentDTO> getAllStudents();
    public StudentDTO getStudentById(Long studentId) throws StudentNotFound;

    public StudentDTO updateStudentById(Long studentId, StudentDTO studentDTO) throws StudentNotFound;

    public String deleteStudentById(Long studentId) throws StudentNotFound;;
}
