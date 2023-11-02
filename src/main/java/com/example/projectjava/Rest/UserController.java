package com.example.projectjava.Rest;


import com.example.projectjava.Dto.UserDTO;
import com.example.projectjava.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }
    @PostMapping("/api/register")
    public ResponseEntity<?> CreateUser(@Valid @RequestBody UserDTO userDTO){
        return userService.CreateUser(userDTO)? ResponseEntity.ok().build():ResponseEntity.status(400).build();
    }
}
