package org.example.springbootdenis.controller;

import jakarta.validation.Valid;
import org.example.springbootdenis.dto.request.UserRequest;
import org.example.springbootdenis.dto.response.UserResponse;
import org.example.springbootdenis.service.user.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserResponse> saveUser(@RequestBody  @Valid UserRequest userRequest){
       return ResponseEntity.ok(userService.save(userRequest));
    }
}
