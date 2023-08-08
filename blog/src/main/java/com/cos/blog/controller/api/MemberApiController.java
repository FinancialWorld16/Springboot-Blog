package com.cos.blog.controller.api;

import com.cos.blog.domain.Member;
import com.cos.blog.domain.RoleType;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody Member member) {
        System.out.println("MemberApiController called");
        member.setRole(RoleType.USER);
        memberService.join(member);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
    
    //Spring Security로 로그인 구현할 거임 ㅇㅇ
    /*@PostMapping("/api/member/login")
    public ResponseDto<Integer> login(@RequestBody Member member, HttpSession session) {
        System.out.println("MemberApiController.login called");
        Member principal=memberService.login(member);

        if(principal!=null) {
            session.setAttribute("principal", principal);
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }*/


}