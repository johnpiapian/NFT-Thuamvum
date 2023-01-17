package com.appzomi.NFTThuamvumBackend.Controller;

import com.appzomi.NFTThuamvumBackend.Domain.Account;
import com.appzomi.NFTThuamvumBackend.Dto.AccountDto;
import com.appzomi.NFTThuamvumBackend.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "")
    public List<Account> getAccounts() {
        return this.accountService.getAccounts();
    }

    @GetMapping(path = "/{id}")
    public Optional<Account> getAccountById(@PathVariable long id) {
        return this.accountService.getAccountById(id);
    }

    @DeleteMapping(path = "/{id}")
    public Optional<Account> deleteAccountById(@PathVariable long id) {
        return this.accountService.deleteAccountById(id);
    }

    @PostMapping(path = "")
    public Optional<Account> addAccount(@RequestBody AccountDto acc) {
        return this.accountService.addAccount(acc);
    }
}
