package com.crud.gateway.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentInputDto {
    @NotBlank
    String firstName;

    @NotBlank
    String lastName;

    @NotBlank
    String middleName;
}
