package org.calderon.courses.domain.dto.intructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InstructorPostDTO {
  @NotBlank private String name;
  @NotBlank private String email;

  @Size(min = 150)
  private String bio;

  private String[] topics;
}
