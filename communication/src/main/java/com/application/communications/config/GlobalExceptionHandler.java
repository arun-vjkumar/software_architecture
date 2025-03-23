package com.application.communications.config;

import com.application.communications.dto.response.ErrorObject;
import com.application.communications.dto.response.HttpApiResponse;
import com.application.communications.exception.CommunicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CommunicationException.class)
    public ResponseEntity<HttpApiResponse<Object>> handleCommunicationException(CommunicationException ex) {
        ErrorObject errorObject = ErrorObject.builder()
                .errorCode(ex.getErrorCode())
                .message(ex.getMessage())
                .build();
        
        HttpApiResponse<Object> response = HttpApiResponse.builder()
                .status(ex.getStatus())
                .error(errorObject)
                .build();
        
        log.error("Communication exception: {}", ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<HttpApiResponse<Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        ErrorObject errorObject = ErrorObject.builder()
                .errorCode(400)
                .message("Validation error: " + errors.entrySet().stream()
                        .map(entry -> entry.getKey() + ": " + entry.getValue())
                        .collect(Collectors.joining(", ")))
                .build();
        
        HttpApiResponse<Object> response = HttpApiResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .error(errorObject)
                .build();
        
        log.error("Validation error: {}", errors);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<HttpApiResponse<Object>> handleEntityNotFoundException(EntityNotFoundException ex) {
        ErrorObject errorObject = ErrorObject.builder()
                .errorCode(404)
                .message(ex.getMessage())
                .build();
        
        HttpApiResponse<Object> response = HttpApiResponse.builder()
                .status(HttpStatus.NOT_FOUND)
                .error(errorObject)
                .build();
        
        log.error("Entity not found: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<HttpApiResponse<Object>> handleConstraintViolationException(ConstraintViolationException ex) {
        String violations = ex.getConstraintViolations().stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.joining(", "));
        
        ErrorObject errorObject = ErrorObject.builder()
                .errorCode(400)
                .message("Constraint violations: " + violations)
                .build();
        
        HttpApiResponse<Object> response = HttpApiResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .error(errorObject)
                .build();
        
        log.error("Constraint violations: {}", violations);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<HttpApiResponse<Object>> handleGenericException(Exception ex) {
        ErrorObject errorObject = ErrorObject.builder()
                .errorCode(500)
                .message("Internal server error: " + ex.getMessage())
                .build();
        
        HttpApiResponse<Object> response = HttpApiResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .error(errorObject)
                .build();
        
        log.error("Unexpected error occurred", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
} 