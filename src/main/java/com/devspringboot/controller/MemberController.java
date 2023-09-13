package com.devspringboot.controller;

import com.devspringboot.dto.JoinMemberRequest;
import com.devspringboot.dto.LoginMemberRequest;
import com.devspringboot.dto.MemberResponse;
import com.devspringboot.entity.Member;
import com.devspringboot.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String home(Principal principal, Model model) {

        if (principal != null) {
            Member member = memberService.findByEmail(principal.getName());

            MemberResponse memberResponse = new MemberResponse(member.getMemberID(), member.getMemberEmail(), member.getMemberNickname());

            model.addAttribute("memberResponse", memberResponse);
        }

        return "home";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false)String error,
                        @RequestParam(value = "exception", required = false)String exception, Model model,Principal principal) {

        if (principal != null) {
            return "redirect:/";
        }

        model.addAttribute("loginMemberRequest", new LoginMemberRequest());
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);

        return "member/login";
    }

    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("joinMemberRequest", new JoinMemberRequest());
        return "member/join";
    }

    @PostMapping("/join")
    public String join(JoinMemberRequest request) {
        memberService.joinMember(request);
        return "redirect:/login";
    }
}
