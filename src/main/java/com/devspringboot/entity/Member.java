package com.devspringboot.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "member")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", updatable = false)
    private Long memberID;

    @Column(name = "member_email", nullable = false, unique = true)
    private String memberEmail;

    @Column(name = "member_password", nullable = false)
    private String memberPassword;

    @Column(name = "member_nickname", nullable = false, unique = true)
    private String memberNickname;

    @Builder
    public Member(String memberEmail, String memberPassword, String memberNickname) {
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberNickname = memberNickname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getPassword() {
        return memberPassword;
    }

    @Override
    public String getUsername() {
        return memberEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
