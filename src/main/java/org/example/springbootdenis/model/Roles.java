package org.example.springbootdenis.model;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    ADMIN("ADMIN") ,
    USER("ROLE");
    private String name;

    Roles(String role) {
        this.name = role;
    }

    @Override
    public @Nullable String getAuthority() {
        return name;
    }
}
