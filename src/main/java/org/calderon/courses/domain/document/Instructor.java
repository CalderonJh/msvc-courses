package org.calderon.courses.domain.document;

import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
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
  private String[] topics;
  List<Course> courses;

  public Instructor() {
    this.courses = new ArrayList<>();
  }

  public List<Course> getCourses() {
    if (courses == null) {
      courses = new ArrayList<>();
    }
    return courses;
  }

  public void addCourse(Course course) {
    getCourses().add(course);
  }
}
