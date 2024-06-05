package org.calderon.courses.domain.document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "courses")
public class Course {
  @Id private String id;

  @NotBlank private Instructor instructor;

  @NotBlank private String name;

  @Size(min = 3)
  private String[] tags;

  @Size(min = 150)
  private String description;

  @NotNull private Double price;
  @NotBlank private String language;

  private Integer studentsAmount = 0;

  private Double rating = 0.0;
  private Integer ratesAmount = 0;
}