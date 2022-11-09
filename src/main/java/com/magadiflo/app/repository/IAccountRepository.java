package com.magadiflo.app.repository;

import com.magadiflo.app.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
