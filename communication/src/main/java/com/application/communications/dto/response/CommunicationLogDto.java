package com.application.communications.dto.response;

import com.application.communications.enums.CommunicationType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommunicationLogDto {
    private Long id;
    private String status;
    private CommunicationType type;
    private String vendor;
}
