package com.crud.gateway.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class StudentOutputDto {
    public final UUID id;
    public final String firstName;
    public final String lastName;
    public final String middleName;
}
