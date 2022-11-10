package com.magadiflo.api.service;

import com.magadiflo.api.model.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getAccounts();
    Account findByUsername(String username);
    Account createAccount(Account account);
}
