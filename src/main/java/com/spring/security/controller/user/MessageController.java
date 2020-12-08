package com.spring.security.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    @GetMapping("/message")
    public String message(){

        return "user/messages";
    }
}
