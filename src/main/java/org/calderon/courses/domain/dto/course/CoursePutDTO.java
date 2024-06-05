package org.calderon.courses.domain.dto.course;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CoursePutDTO {
  private String name;
  private String[] tags;
  private String description;
  private String language;
}