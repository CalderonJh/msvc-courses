package org.calderon.courses.service.usecase;

import jakarta.validation.Valid;
import org.calderon.courses.domain.document.Course;
import org.calderon.courses.domain.dto.course.CoursePostDTO;
import org.calderon.courses.domain.dto.course.CoursePutDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
  Course createCourse(CoursePostDTO course);

  Course getCourse(String courseId);

  Page<Course> getAll(Pageable pageable);

  Page<Course> getByTag(String tag, Pageable pageable);

  Page<Course> getByLanguage(String language, Pageable pageable);

  Page<Course> getByInstructor(String instructorId, Pageable pageable);

  Course updateCourse(String courseId, @Valid CoursePutDTO course);

  Course setPrice(String courseId, Double price);

  Course rateCourse(String courseId, Double rating);

  Course buyCourse(String courseId);

  boolean deleteCourse(String courseId);
}
