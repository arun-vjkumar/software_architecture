package com.application.communications.dto.response;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class HttpApiResponse<T> {
    HttpStatus status;
    T data;
    ErrorObject error;
}
