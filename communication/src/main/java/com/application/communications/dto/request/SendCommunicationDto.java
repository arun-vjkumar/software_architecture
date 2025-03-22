package com.application.communications.dto.request;

import com.application.communications.enums.CommunicationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendCommunicationDto {
    @NotNull(message = "Communication code can't be empty")
    private Long communicationCode;

    @Email
    private String email;

    @NumberFormat
    private String mobile;

    private String fcmToken;
}
