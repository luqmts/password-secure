package com.luq.secure_password.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MinimalDigitsException extends RuntimeException {
    public MinimalDigitsException(String message) {
        super(message);
    }
}
