package com.magadiflo.api.repository;

import com.magadiflo.api.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
