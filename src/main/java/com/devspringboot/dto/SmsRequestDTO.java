package com.devspringboot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
public class SmsRequestDTO {
    private String type;
    private String contentType;
    private String countryCode;
    private String from;
    private String content;
    List<MessageDTO> messages;

    @Builder
    public SmsRequestDTO(String type, String contentType, String countryCode, String from, String content, List<MessageDTO> messages) {
        this.type = type;
        this.contentType = contentType;
        this.countryCode = countryCode;
        this.from = from;
        this.content = content;
        this.messages = messages;
    }
}
