package com.appzomi.NFTThuamvumBackend.Controller;

import com.appzomi.NFTThuamvumBackend.Domain.Account;
import com.appzomi.NFTThuamvumBackend.Dto.AccountDto;
import com.appzomi.NFTThuamvumBackend.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Account>> getAccounts() {
        return ResponseEntity.ok().body(accountService.getAccounts());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Account>> getAccountById(@PathVariable long id) {
        return ResponseEntity.ok().body(accountService.getAccountById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<Account>> deleteAccountById(@PathVariable long id) {
        return ResponseEntity.ok().body(accountService.deleteAccountById(id));
    }

    @PostMapping(path = "")
    public ResponseEntity<Optional<Account>> addAccount(@RequestBody AccountDto acc) {
        return ResponseEntity.ok().body(accountService.addAccount(acc));
    }
}
