package com.application.communications.service;

import com.application.communications.dto.response.CommunicationLogDto;

import javax.validation.constraints.NotNull;

public interface CommunicationLogService {
    CommunicationLogDto getCommunicationLog(@NotNull Long requestId);
}
