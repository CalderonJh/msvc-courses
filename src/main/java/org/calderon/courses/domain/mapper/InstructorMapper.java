package org.calderon.courses.domain.mapper;

import org.calderon.courses.domain.document.Instructor;
import org.calderon.courses.domain.dto.intructor.InstructorPutDTO;
import org.calderon.courses.domain.dto.intructor.InstructorResponseDTO;

public interface InstructorMapper {
	static InstructorResponseDTO toInstructorResponseDTO(Instructor instructor) {
		return InstructorResponseDTO.builder()
				.id(instructor.getId())
				.name(instructor.getName())
				.email(instructor.getEmail())
				.bio(instructor.getBio())
				.courses(instructor.getCourses())
				.topics(instructor.getTopics())
				.build();
	}

	static Instructor toInstructor(InstructorPutDTO instructorPutDTO) {
		return Instructor.builder()
				.name(instructorPutDTO.getName())
				.email(instructorPutDTO.getEmail())
				.bio(instructorPutDTO.getBio())
				.topics(instructorPutDTO.getTopics())
				.build();
	}
}
