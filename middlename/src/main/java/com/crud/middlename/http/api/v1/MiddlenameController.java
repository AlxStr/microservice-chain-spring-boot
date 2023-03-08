package com.crud.middlename.http.api.v1;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.middlename.dto.InputDto;
import com.crud.middlename.dto.LastnameDto;
import com.crud.middlename.dto.OutputDto;
import com.crud.middlename.entity.Middlename;
import com.crud.middlename.service.LastnameService;
import com.crud.middlename.service.MiddlenameService;
import com.crud.middlename.transformer.OutputTransformer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/middlenames")
@RequiredArgsConstructor
public class MiddlenameController {

    private final MiddlenameService middlenameService;

    private final LastnameService lastnameService;

    private final OutputTransformer outputTransformer;

    @GetMapping("/{ownerId}")
    public ResponseEntity<OutputDto> get(@PathVariable UUID ownerId) {
        Middlename middlename = middlenameService.getMiddlename(ownerId);
        LastnameDto lastnameDto = lastnameService.getLastname(ownerId);

        return ResponseEntity.ok(outputTransformer.transform(middlename, lastnameDto));
    }

    @PutMapping("/{ownerId}")
    public ResponseEntity<OutputDto> update(@PathVariable UUID ownerId, @RequestBody InputDto input) {
        Middlename middlename = middlenameService.updateMiddlename(ownerId, input);
        LastnameDto lastnameDto = lastnameService.updateLastname(ownerId, input);

        return ResponseEntity.ok(outputTransformer.transform(middlename, lastnameDto));
    }
}
