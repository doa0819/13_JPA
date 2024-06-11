package com.ohgiraffers.mapping.section01.entity;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberRegistService {

    /* 필기.
    *   마이바티스 -> mapper 사용
    *   JPA -> Repository 사용
    * */

    private MemberRepository memberRepository;

    @Autowired
    public MemberRegistService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void registMember(MemberRegistDTO newMember) {
        // 변경, 확인 할 것들 엔티티 넣기 전에 여기서 로직해준다.
        Member member = new Member(
                newMember.getMemberId(),
                newMember.getMemberPwd(),
                newMember.getMemberName(),
                newMember.getPhone(),
                newMember.getAddress(),
                newMember.getEnrollDate(),
                newMember.getMemberRoll(),
                newMember.getStatus()
        );

        memberRepository.save(member);
    }

    @Transactional
    public String registMemberAndFindName(MemberRegistDTO newMember) {

        registMember(newMember);

        return memberRepository.findNameById(newMember.getMemberId());
    }
}
