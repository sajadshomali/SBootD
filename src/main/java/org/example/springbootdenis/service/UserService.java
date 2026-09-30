package org.example.springbootdenis.service;

import org.example.springbootdenis.dto.request.UserRequest;
import org.example.springbootdenis.dto.response.UserResponse;
import org.example.springbootdenis.model.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public UserResponse save(UserRequest userRequest);
}
