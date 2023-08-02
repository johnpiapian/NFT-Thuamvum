package com.appzomi.NFTThuamvumBackend.Controller;

import com.appzomi.NFTThuamvumBackend.Dto.ProfileResponse;
import com.appzomi.NFTThuamvumBackend.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api")
public class ProfileController {
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(path = "/profile")
    public ResponseEntity<ProfileResponse> getUsers() {
        return ResponseEntity.ok().body(profileService.getProfile());
    }
}
