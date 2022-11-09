package com.magadiflo.app.service;

import com.magadiflo.app.model.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getAccounts();
    Account findByUsername(String username);
    Account createAccount(Account account);
}
