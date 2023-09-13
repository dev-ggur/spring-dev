package com.devspringboot.controller;

import com.devspringboot.dto.MessageDTO;
import com.devspringboot.dto.SmsResponseDTO;
import com.devspringboot.service.SmsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
@RestController
public class SmsController {

    private final SmsService smsService;

    @GetMapping("/send")
    public String getSmsPage() {
        return "sendSms";
    }

    @PostMapping("/sms/send")
    public String sendSms(@RequestBody MessageDTO messageDto, Model model) throws JsonProcessingException, RestClientException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println("controller-=>"+messageDto.toString());
        SmsResponseDTO response = smsService.sendSms(messageDto);
        model.addAttribute("response", response);
        return "result";
    }
}
