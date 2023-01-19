package com.appzomi.NFTThuamvumBackend.Controller;

import com.appzomi.NFTThuamvumBackend.Dao.User;
import com.appzomi.NFTThuamvumBackend.Dto.UserDto;
import com.appzomi.NFTThuamvumBackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<Optional<User>> deleteUserById(@PathVariable long id) {
        return ResponseEntity.ok().body(userService.deleteUserById(id));
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Optional<User>> addUser(@RequestBody UserDto acc) {
        return ResponseEntity.ok().body(userService.addUser(acc));
    }
}
