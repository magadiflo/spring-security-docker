package com.magadiflo.app.service.impl;

import com.magadiflo.app.model.Account;
import com.magadiflo.app.model.Role;
import com.magadiflo.app.repository.IAccountRepository;
import com.magadiflo.app.repository.IRoleRepository;
import com.magadiflo.app.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements IAccountService {

    private final IAccountRepository accountRepository;
    private final IRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<Account> getAccounts() {
        return this.accountRepository.findAll();
    }

    @Override
    public Account findByUsername(String username) {
        return this.accountRepository.findByUsername(username);
    }

    @Override
    public Account createAccount(Account account) {
        Role role = this.roleRepository.findByName("ROLE_USER");

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        account.setRoles(roles);
        account.setPassword(this.passwordEncoder.encode(account.getPassword()));

        return this.accountRepository.save(account);
    }
}
