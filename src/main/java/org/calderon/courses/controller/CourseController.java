package org.calderon.courses.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.calderon.courses.domain.dto.course.CoursePostDTO;
import org.calderon.courses.domain.dto.course.CoursePutDTO;
import org.calderon.courses.domain.dto.course.CourseResponseDTO;
import org.calderon.courses.domain.mapper.CourseMapper;
import org.calderon.courses.service.usecase.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
  private final CourseService courseService;

  @PostMapping("/new")
  public ResponseEntity<CourseResponseDTO> createCourse(@RequestBody @Valid CoursePostDTO dto) {
    return ResponseEntity.ok(
        CourseMapper.INSTANCE.toCourseResponseDTO(courseService.createCourse(dto)));
  }

  @GetMapping("/all")
  public ResponseEntity<Page<CourseResponseDTO>> getAllCourses(@PageableDefault Pageable pageable) {
    return ResponseEntity.ok(
        courseService.getAll(pageable).map(CourseMapper.INSTANCE::toCourseResponseDTO));
  }

  @GetMapping("/filter/tag/{tag}")
  public ResponseEntity<Page<CourseResponseDTO>> getByTag(
      @PathVariable String tag, @PageableDefault Pageable pageable) {
    return ResponseEntity.ok(
        courseService.getByTag(tag, pageable).map(CourseMapper.INSTANCE::toCourseResponseDTO));
  }

  @GetMapping("/filter/language/{language}")
  public ResponseEntity<Page<CourseResponseDTO>> getByLanguage(
      @PathVariable String language, @PageableDefault Pageable pageable) {
    return ResponseEntity.ok(
        courseService
            .getByLanguage(language, pageable)
            .map(CourseMapper.INSTANCE::toCourseResponseDTO));
  }

  @GetMapping("/filter/instructor/{instructorId}")
  public ResponseEntity<Page<CourseResponseDTO>> getByInstructor(
      @PathVariable String instructorId, @PageableDefault Pageable pageable) {
    return ResponseEntity.ok(
        courseService
            .getByInstructor(instructorId, pageable)
            .map(CourseMapper.INSTANCE::toCourseResponseDTO));
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<CourseResponseDTO> updateCourse(
      @PathVariable String id, @RequestBody @Valid CoursePutDTO dto) {
    return ResponseEntity.ok(
        CourseMapper.INSTANCE.toCourseResponseDTO(courseService.updateCourse(id, dto)));
  }

  @PutMapping("/set-price/{id}")
  public ResponseEntity<CourseResponseDTO> setPrice(
      @PathVariable String id, @RequestParam Double price) {
    return ResponseEntity.ok(
        CourseMapper.INSTANCE.toCourseResponseDTO(courseService.setPrice(id, price)));
  }

  @PutMapping("/rate/{id}")
  public ResponseEntity<CourseResponseDTO> rateCourse(
      @PathVariable String id, @RequestParam Double rating) {
    return ResponseEntity.ok(
        CourseMapper.INSTANCE.toCourseResponseDTO(courseService.rateCourse(id, rating)));
  }

  @PutMapping("/buy/{id}")
  public ResponseEntity<CourseResponseDTO> buyCourse(@PathVariable String id) {
    return ResponseEntity.ok(CourseMapper.INSTANCE.toCourseResponseDTO(courseService.buyCourse(id)));
  }

}
