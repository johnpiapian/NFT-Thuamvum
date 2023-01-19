package com.appzomi.NFTThuamvumBackend.Controller;

import com.appzomi.NFTThuamvumBackend.Dto.ProfileResponse;
import com.appzomi.NFTThuamvumBackend.Dto.UserDto;
import com.appzomi.NFTThuamvumBackend.Service.JwtService;
import com.appzomi.NFTThuamvumBackend.Service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api")
public class ProfileController {
    private final ProfileService profileService;
    private final JwtService jwtService;

    public ProfileController(ProfileService profileService, JwtService jwtService, AuthenticationManager authenticationManager, AuthenticationManager authenticationManager1) {
        this.profileService = profileService;
        this.jwtService = jwtService;
    }

    @GetMapping(path = "/profile")
    public ResponseEntity<ProfileResponse> getUsers() {
        return ResponseEntity.ok().body(profileService.getProfile());
    }
}
