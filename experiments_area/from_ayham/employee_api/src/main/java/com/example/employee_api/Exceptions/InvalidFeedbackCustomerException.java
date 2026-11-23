package com.example.employee_api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFeedbackCustomerException extends RuntimeException {
    public InvalidFeedbackCustomerException(String message) {
        super(message);
    }
}
