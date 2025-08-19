package com.luq.secure_password.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MinimalUpperCaseException extends RuntimeException {
    public MinimalUpperCaseException(String message) {
        super(message);
    }
}
