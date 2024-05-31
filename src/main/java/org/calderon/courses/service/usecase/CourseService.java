package org.calderon.courses.service.usecase;

import jakarta.validation.Valid;
import org.calderon.courses.domain.document.Course;
import org.calderon.courses.domain.dto.course.CoursePostDTO;
import org.calderon.courses.domain.dto.course.CoursePutDTO;
import org.springframework.data.domain.Page;

public interface CourseService {
  Course createCourse(CoursePostDTO course);

  Course getCourse(String courseId);

  Page<Course> getAll();

  Page<Course> getByTag(String tag);

  Page<Course> getByLanguage(String language);

  Page<Course> getByInstructor(String instructorId);

  Course updateCourse(String courseId, @Valid CoursePutDTO course);

  Course setPrice(String courseId, double price);

  boolean rateCourse(String courseId, double rating);
}
