package com.student_service.controller;

import com.student_service.document.StudentDTO;
import com.student_service.exception.StudentNotFound;
import com.student_service.service.StudentServiceImpl;
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
@RequestMapping("/api/students")
@Validated
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) throws StudentNotFound {
       logger.info("getStudentById");
        return  new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        logger.info("getAllStudents");
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent( @Valid @RequestBody StudentDTO studentDTO) {
        logger.info("createStudent");
        return new ResponseEntity<>(studentService.createStudent(studentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudentById(@PathVariable Long id, @RequestBody StudentDTO studentDTO) throws StudentNotFound {
       logger.info("updateStudentById");
        return new ResponseEntity<>(studentService.updateStudentById(id, studentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long studentId) throws StudentNotFound {
        logger.info("deleteStudentById");
        return new ResponseEntity<>(studentService.deleteStudentById(studentId), HttpStatus.OK);
    }
}
