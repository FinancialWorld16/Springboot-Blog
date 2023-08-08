package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//인증이 필요없는 곳에 auth
@Controller
public class MemberController {

    @GetMapping("/auth/joinForm")
    public String joinForm() {

        return "member/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm() {

        return "member/loginForm";
    }

}
