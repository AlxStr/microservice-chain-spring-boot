package com.crud.middlename.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.middlename.dto.InputDto;
import com.crud.middlename.entity.Middlename;
import com.crud.middlename.exception.MiddlenameNotFoundException;
import com.crud.middlename.repository.MiddlenameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MiddlenameService {

    @Autowired
    private final MiddlenameRepository middlenameRepository;

    public Middlename getMiddlename(UUID ownerId) {
        return this.middlenameRepository.findById(ownerId)
            .orElseThrow(() -> new MiddlenameNotFoundException());
    }

    public Middlename updateMiddlename(UUID id, InputDto input) {
        Middlename middlename = getMiddlename(id);
        middlename.setMiddleName(input.getMiddleName());;
        middlenameRepository.flush();

        return middlename;
    }
}
