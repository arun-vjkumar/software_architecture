package com.application.communications.dto.request;

import com.application.communications.enums.CommunicationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SendCommunicationDto {
    @NotNull(message = "Communication code can't be empty")
    private Long communicationCode;

    @Email
    private String email;

    @NumberFormat
    private String mobile;

    private String fcmToken;
}
