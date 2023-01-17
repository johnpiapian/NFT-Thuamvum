package com.appzomi.NFTThuamvumBackend.Service;

import com.appzomi.NFTThuamvumBackend.Domain.User;
import com.appzomi.NFTThuamvumBackend.Dto.LoginDto;
import com.appzomi.NFTThuamvumBackend.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<String> authenticateUser(LoginDto loginForm) {

        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        Optional<User> result = userRepository.findUserByUsernameAndPassword(username, password);

        if(result.isPresent()) {
            return "This should be the token".describeConstable();
        }

        return "Error occurred!!".describeConstable();
    }
}
