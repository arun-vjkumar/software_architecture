package com.application.communications.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorObject {
    private int errorCode;
    private String message;
}
