package com.spring.security.aopsecurity;

import org.springframework.stereotype.Service;

/**
 * Aop method 보안방식 서비스 로직을 제공하는 class
 */
@Service
public class AopMethodService {
    /**
     * method에 권한이 있으면 실행되는 함수
     */
    public void methodSecured() {
        System.out.println("methodSecured");
    }
}
