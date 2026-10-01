package org.example.springbootdenis.service.user;

import org.example.springbootdenis.dto.request.UserRequest;
import org.example.springbootdenis.dto.response.UserResponse;
import org.example.springbootdenis.exceptions.MyExceptionRules;
import org.example.springbootdenis.model.User;
import org.example.springbootdenis.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserResponse save(UserRequest userRequest) {
        Optional<User> byUsername = userRepository.findByUsername(userRequest.getUsername());
        if (!byUsername.isEmpty()){
            throw new MyExceptionRules("Username.is.exist");
        }
        return mapUserToUserResponse(userRepository.save(mapUserRequestToUser(userRequest)));
    }

    private User mapUserRequestToUser(UserRequest userRequest){
        return User.builder().username(userRequest.getUsername())
                .password(userRequest.getPassword()).build();
    }

    private UserResponse mapUserToUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}
