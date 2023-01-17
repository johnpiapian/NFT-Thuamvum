package com.appzomi.NFTThuamvumBackend.Service;

import com.appzomi.NFTThuamvumBackend.Domain.Account;
import com.appzomi.NFTThuamvumBackend.Dto.LoginDto;
import com.appzomi.NFTThuamvumBackend.Repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final AccountRepository accountRepository;

    @Autowired
    public LoginService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Optional<String> authenticateUser(LoginDto loginForm) {

        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        Optional<Account> result = accountRepository.findAccountByUsernameAndPassword(username, password);

        if(result.isPresent()) {
            return "This should be the token".describeConstable();
        }

        return "Error occurred!!".describeConstable();
    }
}
