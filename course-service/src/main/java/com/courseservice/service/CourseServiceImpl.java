package com.courseservice.service;


import com.courseservice.document.Course;
import com.courseservice.document.CourseDTO;
import com.courseservice.exception.CourseNotFound;
import com.courseservice.repo.CourseRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service(value = "courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = modelMapper.map(courseDTO, Course.class);
        Course newCourse = courseRepo.save(course);
        return modelMapper.map(newCourse, CourseDTO.class);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepo.findAll();
        List<CourseDTO> courseDTOs = courses.stream().map(c -> modelMapper.map(c, CourseDTO.class)).collect(Collectors.toList());
        return courseDTOs;
    }

    @Override
    public CourseDTO getCourseById(Long id) throws CourseNotFound {
        Course course = courseRepo.findById(id).orElseThrow(()-> new CourseNotFound("Course not found with id " + id));
        return modelMapper.map(course, CourseDTO.class);
    }

    @Override
    public CourseDTO updateCourse(Long id,String title, String courseDescription, String category) throws CourseNotFound {
        Course course = courseRepo.findById(id).orElseThrow(()-> new CourseNotFound("Course not found with id " + id));
        course.setCourseName(title);
        course.setCourseDescription(courseDescription);
        course.setCategory(category);
        return modelMapper.map(courseRepo.save(course), CourseDTO.class);
    }

    @Override
    public String deleteCourse(Long id) {
        courseRepo.deleteById(id);
        return "Course with id " + id + " deleted";
    }

    @Override
    public List<CourseDTO> getCourseByCategory( String category) {
        List<Course> courses = courseRepo.findByCategory(category);
        List<CourseDTO> newList = courses.stream().map(c -> modelMapper.map(c, CourseDTO.class)).collect(Collectors.toList());
        return newList;
    }

    @Override
    public List<CourseDTO> getCourseByCourseName(String courseName) {
        List<Course> courses = courseRepo.findByCourseName(courseName);
        List<CourseDTO> newList = courses.stream().map(c -> modelMapper.map(c, CourseDTO.class)).collect(Collectors.toList());
        return newList;
    }

}