package org.calderon.courses.domain.document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "courses")
public class Course {
  @Id private String id;

  @NotBlank private String instructorId;

  @NotBlank private String name;

  @Size(min = 3)
  private String[] tags;

  @Size(min = 150)
  private String description;

  @NotNull private Double price;
  @NotBlank private String language;
  private Integer studentsAmount;
  private Double rating;
}