package com.appzomi.NFTThuamvumBackend.Service;

import com.appzomi.NFTThuamvumBackend.Dao.Role;
import com.appzomi.NFTThuamvumBackend.Dao.User;
import com.appzomi.NFTThuamvumBackend.Dto.LoginRequest;
import com.appzomi.NFTThuamvumBackend.Dto.TokenResponse;
import com.appzomi.NFTThuamvumBackend.Dto.UserDto;
import com.appzomi.NFTThuamvumBackend.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticateService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticateService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public TokenResponse authenticateUser(LoginRequest _user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        _user.getUsername(),
                        _user.getPassword()
                )
        );

        var user = userRepository.findUserByUsername(_user.getUsername()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return TokenResponse.builder().token(jwtToken).build();
    }

    public TokenResponse register(UserDto usr) {
        User user = User.builder()
                .name(usr.getName())
                .username(usr.getUsername())
                .email(usr.getEmail())
                .password(passwordEncoder.encode(usr.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return TokenResponse.builder().token(jwtToken).build();
    }


    private Map<String, Object> defaultClaims(User usr) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", usr.getRole());
        claims.put("email", usr.getEmail());
        claims.put("name", usr.getName());

        return claims;
    }
}
