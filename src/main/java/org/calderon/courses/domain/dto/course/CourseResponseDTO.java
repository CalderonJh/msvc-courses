package org.calderon.courses.domain.dto.course;

import lombok.Builder;
import lombok.Data;
import org.calderon.courses.domain.dto.intructor.InstructorResponseDTO;

@Data
@Builder
public class CourseResponseDTO {
  private String id;
  private String name;
  private String[] tags;
  private String description;
  private Double price;
  private String language;
  private Integer studentsAmount;
  private Double rating;
  private Integer ratesAmount;
  private InstructorResponseDTO instructor;
}