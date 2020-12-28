package com.spring.security.aopsecurity;

import com.spring.security.domain.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AopSecurityController {

    @Autowired
    private AopMethodService aopMethodService;

    @Autowired
    private AopPointcutService aopPointcutService;

    @Autowired
    private AopLiveMethodService aopLiveMethodService ;

    @GetMapping("/preAuthorize")    // URL 인가체크방식
    @PreAuthorize("hasRole('ROLE_USER') and #account.username == principal.username")   // Annotation 기반 인가 체크방식
    public String preAuthorize(AccountDto account, Model model, Principal principal){

        model.addAttribute("method", "Success @PreAuthorize");

        return "aop/method";

    }

    @GetMapping("/methodSecured")
    public String methodSecured(Model model){

        aopMethodService.methodSecured();
        model.addAttribute("method", "Success MethodSecured");

        return "aop/method";
    }

    @GetMapping("/pointcutSecured")
    public String pointcutSecured(Model model){

        aopPointcutService.notSecured();
        aopPointcutService.pointcutSecured();
        model.addAttribute("method", "Success PointcutSecured");

        return "aop/method";
    }

    @GetMapping("/liveMethodSecured")
    public String liveMethodSecured(Model model){

        aopLiveMethodService.liveMethodSecured();
        model.addAttribute("method", "Success LiveMethodSecured");

        return "aop/method";
    }

}
