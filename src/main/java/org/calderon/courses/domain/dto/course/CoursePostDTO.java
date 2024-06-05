package org.calderon.courses.domain.dto.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoursePostDTO {
  @NotBlank private String name;

  @Size(min = 3)
  private String[] tags;

  @Size(min = 150)
  private String description;

  @NotBlank private String language;
  @NotBlank private String instructorId;
  @NotNull private Double price;
}
