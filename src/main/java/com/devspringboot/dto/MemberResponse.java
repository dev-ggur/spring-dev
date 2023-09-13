package com.devspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {

    private Long memberId;
    private String memberEmail;
    private String memberNickname;
}
