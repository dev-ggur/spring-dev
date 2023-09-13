package com.devspringboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginMemberRequest {
    private String memberEmail;
    private String memberPassword;
}
