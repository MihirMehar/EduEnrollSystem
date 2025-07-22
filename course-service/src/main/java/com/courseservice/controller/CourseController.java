package com.courseservice.controller;

import com.courseservice.document.CourseDTO;
import com.courseservice.exception.CourseNotFound;
import com.courseservice.service.CourseServiceImpl;
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
@RequestMapping("/api/courses")
@Validated
public class CourseController {

private  static  final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseServiceImpl courseService;

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@Valid @RequestBody CourseDTO courseDTO)  {
        logger.debug("createCourse");
        logger.info("create new course");
        return  new ResponseEntity<>(courseService.createCourse(courseDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        logger.info("Fetching all courses");
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) throws CourseNotFound {
        logger.info("Fetching course by id");
        return  new ResponseEntity<>(courseService.getCourseById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<CourseDTO> updateCourse(@PathVariable Long id, @RequestParam String title, @RequestParam String courseDescription ,@RequestParam String category) throws CourseNotFound {
        logger.info("Updating course by id");
        return  new ResponseEntity<>(courseService.updateCourse(id,title,courseDescription,category), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        logger.info("Deleting course by id");
        return  new ResponseEntity<>(courseService.deleteCourse(id), HttpStatus.OK);
    }


    @GetMapping("/category/{category}")
    public ResponseEntity<List<CourseDTO>> getCourseByCategory(@PathVariable String category) {
        logger.info("Fetching all courses based on category: {}", category);
        List<CourseDTO> courses = courseService.getCourseByCategory(category);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/courseName/{courseName}")
    public ResponseEntity<List<CourseDTO>> getCourseByCourseName(@PathVariable String courseName) {
        logger.info("Fetching all courses based on courseName: {}", courseName);
        List<CourseDTO> courses = courseService.getCourseByCourseName(courseName);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }


}
