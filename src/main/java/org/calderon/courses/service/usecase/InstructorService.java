package org.calderon.courses.service.usecase;

import java.util.List;
import org.calderon.courses.domain.document.Instructor;
import org.calderon.courses.domain.dto.intructor.InstructorPostDTO;
import org.calderon.courses.domain.dto.intructor.InstructorPutDTO;
import org.springframework.data.domain.Page;

public interface InstructorService {
  Instructor createInstructor(InstructorPostDTO dto);

  Page<Instructor> getAll();

  Page<Instructor> getByTopic(String topic);

  Instructor getInstructor(String id);

  Instructor updateInstructor(String id, InstructorPutDTO dto);
}
