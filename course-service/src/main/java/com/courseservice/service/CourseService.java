package com.courseservice.service;

import com.courseservice.document.CourseDTO;
import com.courseservice.exception.CourseNotFound;

import java.util.List;

public interface CourseService {


     CourseDTO createCourse(CourseDTO courseDTO);

     List<CourseDTO> getAllCourses();

    CourseDTO getCourseById(Long id) throws CourseNotFound;

     CourseDTO updateCourse(Long id,String title, String courseDescription ,String category) throws CourseNotFound;

     String  deleteCourse(Long id);

    // aditional functionality

    List<CourseDTO> getCourseByCategory(String category);

    List<CourseDTO> getCourseByCourseName(String courseName);




}
