package com.appzomi.NFTThuamvumBackend.Controller;

import com.appzomi.NFTThuamvumBackend.Dto.LoginRequest;
import com.appzomi.NFTThuamvumBackend.Dto.TokenResponse;
import com.appzomi.NFTThuamvumBackend.Dto.UserDto;
import com.appzomi.NFTThuamvumBackend.Service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/auth")
public class AuthenticateController {

    private final AuthenticateService authenticateService;

    @Autowired
    public AuthenticateController(AuthenticateService authenticateService) {
        this.authenticateService = authenticateService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok().body(authenticateService.authenticateUser(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@RequestBody UserDto user){
        return ResponseEntity.ok().body(authenticateService.register(user));
    }
}
