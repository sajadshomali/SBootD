package org.example.springbootdenis.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    @NotNull(message = "{null.username.input}")
    @NotBlank(message = "{empty.username.input}")
    private String username;
    @NotNull(message = "{null.password.input}")
    @NotBlank(message = "{empty.password.input}")
    private String password;
}
