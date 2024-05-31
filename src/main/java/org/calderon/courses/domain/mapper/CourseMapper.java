package org.calderon.courses.domain.mapper;

import org.calderon.courses.domain.document.Course;
import org.calderon.courses.domain.dto.course.CourseResponseDTO;

public interface CourseMapper {
	static CourseResponseDTO toCourseResponseDTO(Course course) {
		return CourseResponseDTO.builder()
				.id(course.getId())
				.name(course.getName())
				.tags(course.getTags())
				.description(course.getDescription())
				.price(course.getPrice())
				.language(course.getLanguage())
				.studentsAmount(course.getStudentsAmount())
				.rating(course.getRating())
				.instructor(null)
				.build();
	}
}