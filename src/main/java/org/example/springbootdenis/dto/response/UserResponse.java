package org.example.springbootdenis.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class UserResponse {
    private int id;
    private String username;
}
