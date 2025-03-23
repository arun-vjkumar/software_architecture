package com.application.communications.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommunicationException extends RuntimeException {
    private final HttpStatus status;
    private final int errorCode;

    public CommunicationException(String message, HttpStatus status, int errorCode) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }

    public CommunicationException(String message, HttpStatus status) {
        this(message, status, status.value());
    }

    public CommunicationException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
} 