package com.spring.security.controller.user;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    @GetMapping("/mypage")
    public String myPage(){

        return "user/mypage";
    }
}


