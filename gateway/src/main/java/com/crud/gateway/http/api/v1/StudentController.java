package com.crud.gateway.http.api.v1;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.gateway.dto.StudentDto;
import com.crud.gateway.dto.StudentInputDto;
import com.crud.gateway.dto.StudentOutputDto;
import com.crud.gateway.service.StudentService;
import com.crud.gateway.transformer.StudentOutputTransformer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentOutputTransformer outputTransformer;

    @GetMapping
    public List<StudentOutputDto> index() {
        return this.studentService.getAllStudents()
            .stream()
            .map(outputTransformer::transform)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentOutputDto> get(@PathVariable UUID id) {
        StudentDto studentDto = studentService.getStudentById(id);
        StudentOutputDto dto = outputTransformer.transform(studentDto);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<StudentOutputDto> create(@Validated @RequestBody StudentInputDto input) {
        StudentDto studentDto = studentService.createStudent(input);
        StudentOutputDto dto = outputTransformer.transform(studentDto);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentOutputDto> update(@PathVariable UUID id,
            @Validated @RequestBody StudentInputDto input) {
        StudentDto studentDto = studentService.updateStudent(id, input);
        StudentOutputDto dto = outputTransformer.transform(studentDto);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        studentService.deleteStudent(id);

        return ResponseEntity.noContent()
            .build();
    }
}
