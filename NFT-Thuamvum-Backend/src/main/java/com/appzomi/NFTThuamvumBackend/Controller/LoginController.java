package com.appzomi.NFTThuamvumBackend.Controller;

import com.appzomi.NFTThuamvumBackend.Dto.LoginDto;
import com.appzomi.NFTThuamvumBackend.Dto.TokenDto;
import com.appzomi.NFTThuamvumBackend.Dto.UserDto;
import com.appzomi.NFTThuamvumBackend.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/auth")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginForm){
        return ResponseEntity.ok().body(loginService.authenticateUser(loginForm));
    }

    @PostMapping("/register")
    public ResponseEntity<TokenDto> register(@RequestBody UserDto user){
        return ResponseEntity.ok().body(loginService.register(user));
    }
}
