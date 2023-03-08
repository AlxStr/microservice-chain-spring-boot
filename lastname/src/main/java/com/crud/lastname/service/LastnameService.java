package com.crud.lastname.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.lastname.dto.InputDto;
import com.crud.lastname.entity.Lastname;
import com.crud.lastname.exception.LastnameNotFoundException;
import com.crud.lastname.repository.LastnameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LastnameService {

    @Autowired
    private final LastnameRepository lastnameRepository;

    public Lastname getLastname(UUID ownerId) {
        return this.lastnameRepository.findById(ownerId)
            .orElseThrow(() -> new LastnameNotFoundException());
    }

    public Lastname updateLastname(UUID ownerId, InputDto input) {
        Lastname lastname = getLastname(ownerId);
        lastname.setLastName(input.getLastName());;
        lastnameRepository.flush();

        return lastname;
    }
}
