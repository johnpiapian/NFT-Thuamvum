package com.appzomi.NFTThuamvumBackend.Controller;

import com.appzomi.NFTThuamvumBackend.Dto.LoginDto;
import com.appzomi.NFTThuamvumBackend.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/auth")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("login")
    public Optional<String> login(@RequestBody LoginDto loginForm){
        return loginService.authenticateUser(loginForm);
    }
}
