package com.crud.gateway.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.crud.gateway.dto.StudentDto;
import com.crud.gateway.dto.StudentInputDto;
import com.crud.gateway.entity.Student;
import com.crud.gateway.exception.StudentNotFoundException;
import com.crud.gateway.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final NamesService namesService;

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
            .stream()
            .map((Student s) -> {
                StudentDto names = this.namesService.getNames(s.getId());
                return this.buildStudentDto(s.getId(), s.getFirstName(), names.getLastName(), names.getMiddleName());
            })
            .collect(Collectors.toList());
    }

    public StudentDto getStudentById(UUID id) {
        Student student = studentRepository.findById(id)
            .orElseThrow(StudentNotFoundException::new);

        StudentDto names = this.namesService.getNames(id);

        return this.buildStudentDto(student.getId(), student.getFirstName(), names.getLastName(),
                names.getMiddleName());
    }

    public StudentDto createStudent(StudentInputDto input) {
        Student student = new Student();
        student.setFirstName(input.getFirstName());

        studentRepository.save(student);

        StudentDto names = this.namesService.updateNames(student.getId(), input);

        return this.buildStudentDto(student.getId(), student.getFirstName(), names.getLastName(),
                names.getMiddleName());
    }

    public StudentDto updateStudent(UUID id, StudentInputDto input) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException());

        student.setFirstName(input.getFirstName());

        studentRepository.save(student);

        StudentDto names = this.namesService.updateNames(id, input);

        return this.buildStudentDto(id, student.getFirstName(), names.getLastName(), names.getMiddleName());
    }

    public void deleteStudent(UUID id) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException());

        studentRepository.delete(student);
    }

    private StudentDto buildStudentDto(UUID id, String firstName, String lastName, String middleName) {
        return StudentDto.builder()
            .id(id)
            .firstName(firstName)
            .middleName(middleName)
            .lastName(lastName)
            .build();
    }
}