package org.calderon.courses.service.impl;

import static org.calderon.courses.util.MessagesKeys.INSTRUCTOR_NOT_FOUND;

import dev.jhonc.lib.common.exception.NoDataException;
import dev.jhonc.lib.common.service.Messages;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.calderon.courses.domain.document.Instructor;
import org.calderon.courses.domain.dto.intructor.InstructorPostDTO;
import org.calderon.courses.domain.dto.intructor.InstructorPutDTO;
import org.calderon.courses.domain.mapper.InstructorMapper;
import org.calderon.courses.repository.CourseRepository;
import org.calderon.courses.repository.InstructorRepository;
import org.calderon.courses.service.usecase.InstructorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
  private final InstructorRepository instructorRepository;
  private final CourseRepository courseRepository;
  private final Messages messages;

  @Override
  @Transactional
  public Instructor createInstructor(InstructorPostDTO dto) {
    return this.instructorRepository.save(InstructorMapper.INSTANCE.toInstructor(dto));
  }

  @Override
  public Page<Instructor> getAll(Pageable pageable) {
    return this.instructorRepository.findAll(pageable);
  }

  @Override
  public Page<Instructor> getByTopic(String topic, Pageable pageable) {
    return this.instructorRepository.findByTopics(topic, pageable);
  }

  @Override
  public Instructor getInstructor(String id) {
    return this.instructorRepository
        .findById(id)
        .orElseThrow(() -> new NoDataException(messages.get(INSTRUCTOR_NOT_FOUND, id)));
  }

  @Override
  @Transactional
  public Instructor updateInstructor(String id, InstructorPutDTO dto) {
    Instructor instructor = this.getInstructor(id);
    setNonEmptyFields(instructor, dto);
    return this.instructorRepository.save(instructor);
  }

  private void setNonEmptyFields(Instructor instructor, InstructorPutDTO dto) {
    if (dto.getName() != null) instructor.setName(dto.getName());
    if (dto.getEmail() != null) instructor.setEmail(dto.getEmail());
    if (dto.getBio() != null) instructor.setBio(dto.getBio());
    if (dto.getTopics() != null) instructor.setTopics(dto.getTopics());
  }
}
