package com.magadiflo.api.resource;

import com.magadiflo.api.model.Account;
import com.magadiflo.api.service.IAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/accounts")
public class AccountResource {

    private final IAccountService accountService;

    public AccountResource(IAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account newAccount = this.accountService.createAccount(account);
        return ResponseEntity.created(EmployeeResource.getLocation(newAccount.getId().intValue())).body(newAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts() {
        return ResponseEntity.ok(this.accountService.getAccounts());
    }

}
