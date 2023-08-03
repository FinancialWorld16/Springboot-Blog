package com.cos.blog.controller;

import com.cos.blog.domain.Member;
import com.cos.blog.domain.RoleType;
import com.cos.blog.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired //의존성 주입 DI
    private MemberRepository memberRepository;

    //한 페이지당 2명씩 출력 paging)
    @GetMapping("/dummy/member")
    public List<Member> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC)Pageable pageable) {
        Page<Member> pagingMember = memberRepository.findAll(pageable);

        List<Member> members = pagingMember.getContent();
        return members;
    }


    @GetMapping("/dummy/memberList")
    public List<Member> list(){
        return memberRepository.findAll();
    }

    /*@GetMapping("/dummy/member/page")
    public Page<Member> pageList*/


    @GetMapping("/dummy/member/{id}")
    public Member detail(@PathVariable Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 유저는 없습니다. id: " + id)
        ); //람다
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

    //password, email 수정
    @Transactional //save없이 update 가능! 함수 종료시에 자동 commit이 됨
    @PutMapping("/dummy/member/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member requestMember) {

        Member member = memberRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("수정에 실패하였습니다.");
        });

        member.setPassword(requestMember.getPassword());
        member.setEmail(requestMember.getEmail());
        return member;

//        memberRepository.save(member);
    }

    @DeleteMapping("/dummy/member/{id}")
    public String deleteMember(@PathVariable Long id) {
        try {
            Member member = memberRepository.findById(id).get();
            memberRepository.delete(member);
        } catch (Exception e) {
            return "삭제에 실패하였습니다."+id+"번 Member는 없습니다.";
        }
        return id+"번 Member 삭제되었습니다.";

    }

} //Controller 끝