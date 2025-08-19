package com.luq.secure_password.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AggregationException extends RuntimeException {
    private final List<? extends RuntimeException> exceptions;

    public AggregationException(List<? extends RuntimeException> exceptions) {
        super(buildMessage(exceptions));
        this.exceptions = exceptions;
    }

    public List<? extends RuntimeException> getExceptions() {
        return exceptions;
    }

    private static String buildMessage(List<? extends RuntimeException> exceptions) {
        StringBuilder sb = new StringBuilder("Validation failed due to following problems:");
        for (RuntimeException ex : exceptions) {
            sb.append(" ").append(ex.getMessage()).append(";");
        }

        return sb.toString();
    }
}
