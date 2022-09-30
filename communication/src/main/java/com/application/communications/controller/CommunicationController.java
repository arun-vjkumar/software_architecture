package com.application.communications.controller;

import com.application.communications.dto.request.SendCommunicationDto;
import com.application.communications.dto.response.CommunicationLogDto;
import com.application.communications.dto.response.ErrorObject;
import com.application.communications.dto.response.HttpApiResponse;
import com.application.communications.dto.response.SendCommunicationResponseDto;
import com.application.communications.service.CommunicationLogService;
import com.application.communications.service.CommunicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class CommunicationController {
    private final CommunicationService communicationService;
    private final CommunicationLogService communicationLogService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public HttpApiResponse<List<SendCommunicationResponseDto> > sendCommunication(@RequestBody SendCommunicationDto requestDto) {
        try {
            List<SendCommunicationResponseDto> response = communicationService.sendCommunication(requestDto);
            return new HttpApiResponse<>(HttpStatus.ACCEPTED, response, getInternalServerError());
        } catch (Exception e) {
            return new HttpApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, getInternalServerError());
        }
    }

    @GetMapping("/:id")
    @ResponseStatus(HttpStatus.OK)
    public HttpApiResponse<CommunicationLogDto> getCommunication(@PathVariable("id") Long communicationLogId) {
        try {
            CommunicationLogDto communicationLogsDto = communicationLogService.getCommunicationLog(communicationLogId);
            return new HttpApiResponse(HttpStatus.OK, communicationLogsDto, getInternalServerError());
        } catch (Exception e) {
            return new HttpApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, getInternalServerError());
        }
    }

    private ErrorObject getInternalServerError() {
        return ErrorObject.builder()
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Something went wrong")
                .build();
    }
}
