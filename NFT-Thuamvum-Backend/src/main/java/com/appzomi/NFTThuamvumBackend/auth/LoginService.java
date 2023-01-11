package com.appzomi.NFTThuamvumBackend.auth;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    public Optional<String> authenticateUser(LoginDTO loginForm) {

        String res = "Failed!";

        if (loginForm.getUsername().compareToIgnoreCase("John") == 0 && loginForm.getPassword().equals("password"))
            res = "This is the token!";

        return res.describeConstable();
    }
}
