package com.crud.middlename.transformer;

import org.springframework.stereotype.Service;

import com.crud.middlename.dto.LastnameDto;
import com.crud.middlename.dto.OutputDto;
import com.crud.middlename.entity.Middlename;

@Service
public class OutputTransformer {
    public OutputDto transform(Middlename middlename, LastnameDto lastname) {
        return new OutputDto(middlename.getMiddleName(), lastname.getLastName());
    }
}
