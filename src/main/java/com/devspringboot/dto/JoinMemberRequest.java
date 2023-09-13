package com.devspringboot.dto;

import com.devspringboot.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinMemberRequest {
    private String memberEmail;
    private String memberPassword;
    private String memberNickname;

    public Member toEntity(String encodedPassword) {
        return Member.builder()
                .memberEmail(this.memberEmail)
                .memberPassword(encodedPassword)
                .memberNickname(this.memberNickname)
                .build();
    }
}
