package com.spring.security.repository;

import com.spring.security.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);

}
