package com.cos.blog.controller;

import com.cos.blog.domain.Member;
import com.cos.blog.domain.RoleType;
import com.cos.blog.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired //의존성 주입 DI
    private MemberRepository memberRepository;

    @GetMapping("/dummy/memberList")
    public List<Member> list(){
        return memberRepository.findAll();
    }

    @GetMapping("/dummy/member/page")
    public Page<Member> pageList


    @GetMapping("/dummy/member/{id}")
    public Member detail(@PathVariable Long id) {
        Member member = memberRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 유저는 없습니다. id: " + id)); //람다
        return member; //이 객체를 브라우저에서 자동으로 json으로 해줌
    }


    @PostMapping("/dummy/join")
    public String join(Member member) {
        System.out.println("id = " + member.getId());
        System.out.println("memberName = " + member.getMemberName());
        System.out.println("password = " + member.getPassword());
        System.out.println("email = " + member.getEmail());
        System.out.println("role = " + member.getRole());
        System.out.println("m.getCreateDate() = " + member.getCreateDate());

        member.setRole(RoleType.USER);

        memberRepository.save(member);

        return "회원가입이 완료되었습니다.";
    }
}
