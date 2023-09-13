package com.devspringboot.repository;

import com.devspringboot.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberEmail(String memberEmail);

    Optional<Member> findByMemberEmailAndMemberPassword(String memberEmail, String memberPassword);
}
