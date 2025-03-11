package com.example.basicfilter.member.repository;

import com.example.basicfilter.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
