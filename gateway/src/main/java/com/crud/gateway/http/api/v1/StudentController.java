package com.crud.gateway.http.api.v1;

import java.util.List;
import java.util.UUID;

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
import com.crud.gateway.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> index() {
        return this.studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> get(@PathVariable UUID id) {
        StudentDto studentDto = studentService.getStudentById(id);

        return ResponseEntity.ok(studentDto);
    }

    @PostMapping
    public ResponseEntity<StudentDto> create(@Validated @RequestBody StudentDto input) {
        StudentDto studentDto = studentService.createStudent(input);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(studentDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> update(@PathVariable UUID id, @Validated @RequestBody StudentDto input) {
        StudentDto studentDto = studentService.updateStudent(id, input);

        return ResponseEntity.ok(studentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        studentService.deleteStudent(id);

        return ResponseEntity.noContent()
            .build();
    }
}
