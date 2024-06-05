package org.calderon.courses.domain.dto.intructor;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.calderon.courses.domain.dto.course.CourseResponseDTO;

@Data
@Builder
public class InstructorResponseDTO {
  private String id;
  private String name;
  private String email;
  private String bio;
  private String[] topics;
  private List<CourseResponseDTO> courses;
}
