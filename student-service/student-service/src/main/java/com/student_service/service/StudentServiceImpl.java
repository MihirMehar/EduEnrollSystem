package com.student_service.service;

import com.student_service.document.Student;
import com.student_service.document.StudentDTO;
import com.student_service.exception.StudentNotFound;
import com.student_service.repo.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student= modelMapper.map(studentDTO,Student.class);
        studentRepo.save(student);
        return modelMapper.map(student,StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        List<StudentDTO> studentDTOS = students.stream().map(student -> modelMapper.map(student,StudentDTO.class)).collect(Collectors.toList());
        return studentDTOS;
    }

    @Override
    public StudentDTO getStudentById(Long studentId) throws StudentNotFound {
        Student student = studentRepo.findById(studentId).orElseThrow(()->new StudentNotFound("Student Not Found"+studentId));
        return modelMapper.map(student,StudentDTO.class);
    }

    @Override
    public StudentDTO updateStudentById(Long studentId, StudentDTO studentDTO) throws StudentNotFound {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new StudentNotFound("Student Not Found" + studentId));
        // Map the fields from studentDTO to the existing student
        modelMapper.map(studentDTO, student);
        // Save the updated student
        Student student1 = studentRepo.save(student);
        // Mapping the saved student to StudentDTO
        StudentDTO studentDTO1 = modelMapper.map(student1, StudentDTO.class);
        return studentDTO1;
    }


    @Override
    public String deleteStudentById(Long studentId) throws StudentNotFound {
        Student student = studentRepo.findById(studentId).orElseThrow(()->new StudentNotFound("Student Not Found"+studentId));
        studentRepo.delete(student);
        return "Student Deleted Successfully";
    }
}
