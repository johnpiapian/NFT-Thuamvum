package com.appzomi.NFTThuamvumBackend.Service;

import com.appzomi.NFTThuamvumBackend.Domain.Role;
import com.appzomi.NFTThuamvumBackend.Domain.User;
import com.appzomi.NFTThuamvumBackend.Dto.LoginDto;
import com.appzomi.NFTThuamvumBackend.Dto.TokenDto;
import com.appzomi.NFTThuamvumBackend.Dto.UserDto;
import com.appzomi.NFTThuamvumBackend.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public TokenDto authenticateUser(LoginDto loginForm) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginForm.getUsername(),
                        loginForm.getPassword()
                )
        );

        var user = userRepository.findUserByUsername(loginForm.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return TokenDto.builder().token(jwtToken).build();
    }

    public TokenDto register(UserDto usr) {
        User saved = User.builder()
                .name(usr.getName())
                .username(usr.getUsername())
                .email(usr.getEmail())
                .password(passwordEncoder.encode(usr.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(saved);
        var jwtToken = jwtService.generateToken(saved);

        return TokenDto.builder().token(jwtToken).build();
    }

}
