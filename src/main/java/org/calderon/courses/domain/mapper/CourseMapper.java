package org.calderon.courses.domain.mapper;

import org.calderon.courses.domain.document.Course;
import org.calderon.courses.domain.dto.course.CoursePostDTO;
import org.calderon.courses.domain.dto.course.CourseResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {
  CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "rating", ignore = true)
  @Mapping(target = "studentsAmount", ignore = true)
  @Mapping(target = "instructor", ignore = true)
  Course toCourse(CoursePostDTO dto);

  CourseResponseDTO toCourseResponseDTO(Course course);

}
