package com.devspringboot.service;

import com.devspringboot.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberEmail) throws UsernameNotFoundException {
        return memberRepository.findByMemberEmail(memberEmail)
                .orElseThrow(() -> new UsernameNotFoundException("해당 회원을 찾을 수 없습니다."));
    }
}
