package com.example.basicfilter.member.service;

import com.example.basicfilter.member.dto.MemberResponseDto;
import com.example.basicfilter.member.dto.MemberSaveRequestDto;
import com.example.basicfilter.member.dto.MemberSaveResponseDto;
import com.example.basicfilter.member.dto.MemberUpdateRequestDto;
import com.example.basicfilter.member.entity.Member;
import com.example.basicfilter.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto save(MemberSaveRequestDto dto) {

        Member member = new Member(dto.getEmail());
        Member savedMember = memberRepository.save(member);
        return new MemberSaveResponseDto(savedMember.getId(), savedMember.getEmail());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAll() {
        List<Member> members = memberRepository.findAll();
        return members.stream().map(member -> new MemberResponseDto(member.getId(), member.getEmail())).toList();
    }

    @Transactional(readOnly = true)
    public MemberResponseDto findById(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalStateException("그런 사람 없습니다.")
        );
        return new MemberResponseDto(
                member.getId(),
                member.getEmail()
        );
    }

    @Transactional
    public void update(Long memberId, MemberUpdateRequestDto dto) {
         Member member = memberRepository.findById(memberId).orElseThrow(
                 () -> new IllegalStateException("그런 사람 없습니다.")
         );
         member.update(dto.getEmail());
    }

    public void deleteById(Long memberId) {
        if (!memberRepository.existsById(memberId)) {
            throw new IllegalArgumentException("존재하지 않는 사람입니다");
        }
        memberRepository.deleteById(memberId);
    }
}
