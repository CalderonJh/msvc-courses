package org.calderon.courses.service.impl;

import static org.calderon.courses.util.MessagesKeys.*;

import dev.jhonc.lib.common.exception.NoDataException;
import dev.jhonc.lib.common.exception.ValidationException;
import dev.jhonc.lib.common.service.Messages;
import lombok.RequiredArgsConstructor;
import org.calderon.courses.domain.document.Course;
import org.calderon.courses.domain.document.Instructor;
import org.calderon.courses.domain.dto.course.CoursePostDTO;
import org.calderon.courses.domain.dto.course.CoursePutDTO;
import org.calderon.courses.domain.mapper.CourseMapper;
import org.calderon.courses.repository.CourseRepository;
import org.calderon.courses.repository.InstructorRepository;
import org.calderon.courses.service.usecase.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
  private final CourseRepository courseRepository;
  private final InstructorRepository instructorRepository;
  private final Messages messages;

  @Override
  @Transactional
  public Course createCourse(CoursePostDTO dto) {
    Course course = CourseMapper.INSTANCE.toCourse(dto);
    Instructor instructor =
        this.instructorRepository
            .findById(dto.getInstructorId())
            .orElseThrow(
                () ->
                    new NoDataException(messages.get(INSTRUCTOR_NOT_FOUND, dto.getInstructorId())));
    course.setInstructor(instructor);
    Course savedCourse = this.courseRepository.save(course);
    instructor.addCourse(savedCourse);
    this.instructorRepository.save(instructor);
    return savedCourse;
  }

  @Override
  public Course getCourse(String courseId) {
    return this.courseRepository
        .findById(courseId)
        .orElseThrow(() -> new NoDataException(messages.get(COURSE_NOT_FOUND, courseId)));
  }

  @Override
  public Page<Course> getAll(Pageable pageable) {
    return this.courseRepository.findAll(pageable);
  }

  @Override
  public Page<Course> getByTag(String tag, Pageable pageable) {
    return this.courseRepository.getByTag(tag, pageable);
  }

  @Override
  public Page<Course> getByLanguage(String language, Pageable pageable) {
    return this.courseRepository.getByLanguage(language, pageable);
  }

  @Override
  public Page<Course> getByInstructor(String instructorId, Pageable pageable) {
    return this.courseRepository.getByInstructor(instructorId, pageable);
  }

  @Override
  @Transactional
  public Course updateCourse(String courseId, CoursePutDTO course) {
    Course courseToUpdate = this.getCourse(courseId);
    setNonEmptyFields(courseToUpdate, course);
    return this.courseRepository.save(courseToUpdate);
  }

  private void setNonEmptyFields(Course course, CoursePutDTO dto) {
    if (dto.getName() != null) course.setName(dto.getName());
    if (dto.getDescription() != null) course.setDescription(dto.getDescription());
    if (dto.getLanguage() != null) course.setLanguage(dto.getLanguage());
    if (dto.getTags() != null) course.setTags(dto.getTags());
  }

  @Override
  @Transactional
  public Course setPrice(String courseId, Double price) {
    Course course = this.getCourse(courseId);
    course.setPrice(price);
    return this.courseRepository.save(course);
  }

  @Override
  @Transactional
  public Course rateCourse(String courseId, Double rating) {
    if (rating < 0 || rating > 5) throw new ValidationException(messages.get(RATING_INVALID));
    Course course = this.getCourse(courseId);
    int ratesAmount = course.getRatesAmount();
    double currentRating = course.getRating();
    double newRating = (currentRating * ratesAmount + rating) / (ratesAmount + 1);
    course.setRating(newRating);
    course.setRatesAmount(ratesAmount + 1);
    return this.courseRepository.save(course);
  }

  @Override
  public Course buyCourse(String courseId) {
    Course course = this.getCourse(courseId);
    course.setStudentsAmount(course.getStudentsAmount() + 1);
    return this.courseRepository.save(course);
  }

  @Override
  public boolean deleteCourse(String courseId) {
    Course course = this.getCourse(courseId);
    this.courseRepository.delete(course);
    return true;
  }
}
