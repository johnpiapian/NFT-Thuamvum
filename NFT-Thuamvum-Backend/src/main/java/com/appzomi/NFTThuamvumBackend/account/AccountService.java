package com.appzomi.NFTThuamvumBackend.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Optional<Account> deleteAccountById(long id) {
        try {
            Optional<Account> result = getAccountById(id);
            accountRepository.deleteById(id);

            if(result.isEmpty()) throw new Exception();

            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public Optional<Account> addAccount(AccountDTO acc) {
        Account saved = new Account(acc.getName(), acc.getUsername(), acc.getEmail(), acc.getPassword());
        return Optional.of(accountRepository.save(saved));
    }
}
