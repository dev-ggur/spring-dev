package com.devspringboot.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@ToString
public class MessageDTO {
    private String to;
    private String content;

    @Builder
    public MessageDTO(String to, String content) {
        this.to = to;
        this.content = content;
    }
}
