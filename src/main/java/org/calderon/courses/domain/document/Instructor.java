package org.calderon.courses.domain.document;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "instructors")
public class Instructor {
  @Id private String id;
  @NotBlank private String name;
  @NotBlank private String email;
  private String bio;
  private String[] courses;
  private String[] topics;
}