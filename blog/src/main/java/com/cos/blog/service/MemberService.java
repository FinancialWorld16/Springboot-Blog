package com.cos.blog.service;

import com.cos.blog.domain.Member;
import com.cos.blog.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Transactional //성공하면 commit, 아니면 rollback
    public void join(Member member) {
        memberRepository.save(member);
    }

    /*@Transactional(readOnly = true) //select할 때 트래잭션 시작, 서비스 종료시에 트랜잭션 종료(정합성 유지)
    public Member login(Member member) {
        return memberRepository.findByMemberNameAndPassword(member.getMemberName(), member.getPassword());
    }*/
}
