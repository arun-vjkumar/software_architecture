package com.application.communications.service.impl;

import com.application.communications.dto.request.SendCommunicationDto;
import com.application.communications.dto.response.CommunicationLogDto;
import com.application.communications.dto.response.SendCommunicationResponseDto;
import com.application.communications.entity.Communication;
import com.application.communications.enums.CommunicationType;
import com.application.communications.repository.CommunicationRepository;
import com.application.communications.service.CommunicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommunicationServiceImpl implements CommunicationService {
    private final CommunicationRepository communicationRepository;

    @Override
    public List<SendCommunicationResponseDto> sendCommunication(@NotNull SendCommunicationDto sendCommunicationDto) {
        Communication communication = communicationRepository.getReferenceById(sendCommunicationDto.getCommunicationCode());
        if (Objects.isNull(communication))
            throw new RuntimeException();
        return communication.getTypes().stream()
                .map(communicationType -> triggerCommunication(communicationType, sendCommunicationDto))
                .map(this::buildSendCommunicationResponseDto)
                .collect(Collectors.toList());
    }

    private CommunicationLogDto triggerCommunication(
            @NotNull CommunicationType communicationType,
            @NotNull SendCommunicationDto sendCommunicationDto
    ) {
        switch (communicationType) {
            case NOTIFICATION:
                break;
            case SMS:
                break;
            case EMAIL:
                break;
            default:
        }
        throw new RuntimeException();
    }

    private SendCommunicationResponseDto buildSendCommunicationResponseDto(CommunicationLogDto communicationLogDto) {
        return SendCommunicationResponseDto.builder()
                .id(communicationLogDto.getId())
                .status(communicationLogDto.getStatus())
                .type(communicationLogDto.getType())
                .build();
    }
}
