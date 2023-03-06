package com.crud.gateway.transformer;

import org.springframework.stereotype.Service;

import com.crud.gateway.dto.StudentDto;
import com.crud.gateway.dto.StudentOutputDto;

@Service
public class StudentOutputTransformer {
    public StudentOutputDto transform(StudentDto student) {
        return new StudentOutputDto(student.getId(), student.getFirstName(), student.getLastName(),
                student.getMiddleName());
    }
}
