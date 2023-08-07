package com.cos.blog.controller.api;

import com.cos.blog.domain.Member;
import com.cos.blog.domain.RoleType;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/api/member")
    public ResponseDto<Integer> save(@RequestBody Member member) {
        System.out.println("MemberApiController 호출됨");
        member.setRole(RoleType.USER);
        memberService.join(member);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }


}
