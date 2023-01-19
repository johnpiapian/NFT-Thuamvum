package com.appzomi.NFTThuamvumBackend.Service;

import com.appzomi.NFTThuamvumBackend.Dao.User;
import com.appzomi.NFTThuamvumBackend.Dto.ProfileResponse;
import com.appzomi.NFTThuamvumBackend.Repo.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final UserRepository userRepository;

    public ProfileService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ProfileResponse getProfile() {
        // SecurityContextImpl
        // [Authentication=UsernamePasswordAuthenticationToken
        // [Principal=User(id=1, name=Sut, username=sut,
        // email=sut@me.com, password=$2a$10$fSc2t93rShQ1dHjC8jQHVOkrrgBMuvvtsghpGplTPAuvB98WjUuYm,
        // role=USER),
        // Credentials=[PROTECTED],
        // Authenticated=true,
        // Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=null],
        // Granted Authorities=[USER]]]

        User loggedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ProfileResponse profileResponse = ProfileResponse.builder()
                .id(loggedUser.getId())
                .name(loggedUser.getName())
                .username(loggedUser.getUsername())
                .email(loggedUser.getEmail())
                .role(loggedUser.getRole().toString())
                .build();

        return profileResponse;
    }
}
