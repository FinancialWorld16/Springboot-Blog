package com.cos.blog.controller;

import com.cos.blog.domain.Member;
import com.cos.blog.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

    @Autowired //의존성 주입 DI
    private MemberRepository memberRepository;

    @PostMapping("/dummy/join")
    public String join(Member member) {
        System.out.println("id = " + member.getId());
        System.out.println("memberName = " + member.getMemberName());
        System.out.println("password = " + member.getPassword());
        System.out.println("email = " + member.getEmail());
        System.out.println("role = " + member.getRole());
        System.out.println("m.getCreateDate() = " + member.getCreateDate());

        memberRepository.save(member);

        return "회원가입이 완료되었습니다.";
    }
}
