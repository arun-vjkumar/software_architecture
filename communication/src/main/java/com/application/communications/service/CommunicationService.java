package com.application.communications.service;

import com.application.communications.dto.request.SendCommunicationDto;
import com.application.communications.dto.response.SendCommunicationResponseDto;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface CommunicationService {
    List<SendCommunicationResponseDto> sendCommunication(@NotNull SendCommunicationDto sendCommunicationDto);
}
