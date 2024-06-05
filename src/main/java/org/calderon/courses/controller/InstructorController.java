package org.calderon.courses.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.calderon.courses.domain.dto.intructor.InstructorPostDTO;
import org.calderon.courses.domain.dto.intructor.InstructorPutDTO;
import org.calderon.courses.domain.dto.intructor.InstructorResponseDTO;
import org.calderon.courses.domain.mapper.InstructorMapper;
import org.calderon.courses.service.usecase.InstructorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController {
  private final InstructorService instructorService;
  @PostMapping("/new")
  public ResponseEntity<InstructorResponseDTO> createInstructor(
      @RequestBody @Valid InstructorPostDTO dto) {
    return ResponseEntity.ok(
        InstructorMapper.INSTANCE.toInstructorResponseDTO(instructorService.createInstructor(dto)));
  }

  @GetMapping("/all")
  public ResponseEntity<Page<InstructorResponseDTO>> getAllInstructors(@PageableDefault Pageable pageable) {
    return ResponseEntity.ok(
        instructorService.getAll(pageable).map(InstructorMapper.INSTANCE::toInstructorResponseDTO));
  }

  @GetMapping("/filter/topic/{topic}")
  public ResponseEntity<Page<InstructorResponseDTO>> getByTopic(
      @PathVariable String topic, @PageableDefault Pageable pageable) {
    return ResponseEntity.ok(
        instructorService.getByTopic(topic, pageable).map(InstructorMapper.INSTANCE::toInstructorResponseDTO));
  }

  @PutMapping("/{id}")
  public ResponseEntity<InstructorResponseDTO> updateInstructor(
      @PathVariable String id, @RequestBody @Valid InstructorPutDTO dto) {
    return ResponseEntity.ok(
        InstructorMapper.INSTANCE.toInstructorResponseDTO(instructorService.updateInstructor(id, dto)));
  }
}
