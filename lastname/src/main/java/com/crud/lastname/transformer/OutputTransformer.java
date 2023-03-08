package com.crud.lastname.transformer;

import org.springframework.stereotype.Service;

import com.crud.lastname.dto.OutputDto;
import com.crud.lastname.entity.Lastname;

@Service
public class OutputTransformer {
    public OutputDto transform(Lastname lastname) {
        return new OutputDto(lastname.getLastName());
    }
}
