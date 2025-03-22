package com.application.communications.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HttpApiResponse<T> {
    private HttpStatus status;
    private T data;
    private ErrorObject error;
}
