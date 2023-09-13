package com.devspringboot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class SmsResponseDTO {
    private String requestId;
    private LocalDateTime requestTime;
    private String statusCode;
    private String statusName;

    @Builder
    public SmsResponseDTO(String requestId, LocalDateTime requestTime, String statusCode, String statusName) {
        this.requestId = requestId;
        this.requestTime = requestTime;
        this.statusCode = statusCode;
        this.statusName = statusName;
    }
}
