package org.example.springbootdenis.service.user;

import org.example.springbootdenis.dto.request.UserRequest;
import org.example.springbootdenis.dto.response.UserResponse;


public interface UserService {
    public UserResponse save(UserRequest userRequest);
}
