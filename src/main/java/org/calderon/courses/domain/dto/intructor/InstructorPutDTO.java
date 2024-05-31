package org.calderon.courses.domain.dto.intructor;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InstructorPutDTO {
  private String name;
  private String email;

  private String bio;

  private String[] topics;
}
