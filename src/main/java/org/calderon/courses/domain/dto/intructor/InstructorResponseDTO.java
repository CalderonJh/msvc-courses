package org.calderon.courses.domain.dto.intructor;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InstructorResponseDTO {
	private String id;
	private String name;
	private String email;
	private String bio;
	private String[] courses;
	private String[] topics;
}