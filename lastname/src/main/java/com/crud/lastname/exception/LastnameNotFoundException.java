package com.crud.lastname.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LastnameNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "Lastname not found";
    }
}
