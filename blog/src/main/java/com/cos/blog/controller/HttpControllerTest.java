package com.cos.blog.controller;

import com.cos.blog.domain.Member;
import org.springframework.web.bind.annotation.*;
//브라우저를 통해서는 GET 요청만이 가능하다
@RestController
public class HttpControllerTest {

    @GetMapping("/http/get")
    public String getTest(Member m) {
        return "get 요청"+m.getId()+","+m.getMemberName()+","+m.getPassword();
    }

    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m) {
        return "post 요청 "+m.getId()+","+m.getMemberName()+","+m.getPassword()+
                ","+m.getEmail();
    }

    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m) {
        return "put 요청"+m.getId()+","+m.getMemberName()+","+m.getPassword()+
                ","+m.getEmail();
    }

    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }

}
