package com.crud.gateway.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    private UUID id;
    
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String middleName;
}
