package com.courseservice.repo;

import com.courseservice.document.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {

    List<Course> findByCourseName(String courseName);

    List<Course> findByCategory(String category);
}
