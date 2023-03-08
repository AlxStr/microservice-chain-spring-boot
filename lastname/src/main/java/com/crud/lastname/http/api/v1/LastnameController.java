package com.crud.lastname.http.api.v1;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.lastname.dto.InputDto;
import com.crud.lastname.dto.OutputDto;
import com.crud.lastname.entity.Lastname;
import com.crud.lastname.service.LastnameService;
import com.crud.lastname.transformer.OutputTransformer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/lastnames")
@RequiredArgsConstructor
public class LastnameController {

    @Autowired
    private final LastnameService lastnameService;

    @Autowired
    private final OutputTransformer outputTransformer;

    @GetMapping("/{ownerId}")
    public ResponseEntity<OutputDto> get(@PathVariable UUID ownerId) {
        Lastname lastname = lastnameService.getLastname(ownerId);

        return ResponseEntity.ok(outputTransformer.transform(lastname));
    }

    @PutMapping("/{ownerId}")
    public ResponseEntity<OutputDto> update(@PathVariable UUID ownerId, @RequestBody InputDto input) {
        Lastname lastname = lastnameService.updateLastname(ownerId, input);

        return ResponseEntity.ok(outputTransformer.transform(lastname));
    }
}
