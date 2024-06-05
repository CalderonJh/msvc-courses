package org.calderon.courses.repository;

import org.calderon.courses.domain.document.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
  @Query("{'tags': {'$in': ['?0']}}")
  Page<Course> getByTag(String tag, Pageable pageable);

  @Query("{'language': '?0'}")
  Page<Course> getByLanguage(String language, Pageable pageable);

  @Query("{'instructor.id': '?0'}")
  Page<Course> getByInstructor(String instructorId, Pageable pageable);
}
