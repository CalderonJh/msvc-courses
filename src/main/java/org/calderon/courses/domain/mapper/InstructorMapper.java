package org.calderon.courses.domain.mapper;

import org.calderon.courses.domain.document.Instructor;
import org.calderon.courses.domain.dto.intructor.InstructorPostDTO;
import org.calderon.courses.domain.dto.intructor.InstructorResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InstructorMapper {
	InstructorMapper INSTANCE = Mappers.getMapper(InstructorMapper.class);
	InstructorResponseDTO toInstructorResponseDTO(Instructor instructor);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "courses", ignore = true)
	Instructor toInstructor(InstructorPostDTO dto);

}
