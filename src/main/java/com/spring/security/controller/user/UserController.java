package com.spring.security.controller.user;

import com.spring.security.domain.dto.AccountDto;
import com.spring.security.domain.entity.Account;
import com.spring.security.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/mypage")
    public String myPage(){

        return "user/mypage";
    }

    @GetMapping("/users")
    public String createUser(){
        return "user/login/register";
    }

    @PostMapping("/users")
    public String createUser(AccountDto accountDto){

        ModelMapper modelMapper = new ModelMapper();
        Account account = modelMapper.map(accountDto, Account.class);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountService.createAccount(account);

        return "redirect:/";
    }
}


