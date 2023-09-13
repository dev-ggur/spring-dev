package com.devspringboot.service;

import com.devspringboot.dto.JoinMemberRequest;
import com.devspringboot.entity.Member;
import com.devspringboot.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder encoder;

    public Long joinMember(JoinMemberRequest request) {
        return memberRepository.save(request.toEntity(encoder.encode(request.getMemberPassword()))).getMemberID();
    }

    public Member findByEmail(String memberEmail) {
        return memberRepository.findByMemberEmail(memberEmail)
                .orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 유저"));
    }
}
