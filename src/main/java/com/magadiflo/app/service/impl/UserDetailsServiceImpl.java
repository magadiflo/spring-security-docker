package com.magadiflo.app.service.impl;

import com.magadiflo.app.model.Account;
import com.magadiflo.app.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IAccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = this.accountService.findByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException(String.format("User %s not found!", username));
        }

        if (account.getRoles() == null || account.getRoles().isEmpty()) {
            throw new RuntimeException("User has no roles");
        }

        Collection<GrantedAuthority> authorities = account.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

        return new User(account.getUsername(), account.getPassword(), account.isEnabled(),
                !account.isExpired(),
                !account.isCredentialsExpired(),
                !account.isLocked(), authorities);
    }

}
