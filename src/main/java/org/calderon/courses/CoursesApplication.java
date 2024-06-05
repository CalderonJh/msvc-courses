package org.calderon.courses;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

import org.calderon.courses.repository.CourseRepository;
import org.calderon.courses.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableMongoRepositories
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
@Import({dev.jhonc.lib.common.config.CommonLibConfig.class})
public class CoursesApplication {
  CourseRepository courseRepository;

  InstructorRepository instructorRepository;

  public static void main(String[] args) {
    SpringApplication.run(CoursesApplication.class, args);
  }

  @Autowired
  public void setCourseRepository(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  @Autowired
  public void setInstructorRepository(InstructorRepository instructorRepository) {
    this.instructorRepository = instructorRepository;
  }
}
