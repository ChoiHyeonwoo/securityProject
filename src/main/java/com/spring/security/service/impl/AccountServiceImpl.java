package com.spring.security.service.impl;

import com.spring.security.domain.Account;
import com.spring.security.repository.AccountRepository;
import com.spring.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public void createAccount(Account account) {
        accountRepository.save(account);
    }
}
