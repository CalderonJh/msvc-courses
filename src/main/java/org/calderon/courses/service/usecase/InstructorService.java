package org.calderon.courses.service.usecase;

import org.calderon.courses.domain.document.Instructor;
import org.calderon.courses.domain.dto.intructor.InstructorPostDTO;
import org.calderon.courses.domain.dto.intructor.InstructorPutDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InstructorService {
  Instructor createInstructor(InstructorPostDTO dto);

  Page<Instructor> getAll(Pageable pageable);

  Page<Instructor> getByTopic(String topic, Pageable pageable);

  Instructor getInstructor(String id);

  Instructor updateInstructor(String id, InstructorPutDTO dto);
}
