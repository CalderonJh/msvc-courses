package org.calderon.courses.repository;

import org.calderon.courses.domain.document.Instructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends MongoRepository<Instructor, String> {
  @Query("{'topics': {'$in': ['?0']}}")
  Page<Instructor> findByTopics(String topic, Pageable pageable);
}