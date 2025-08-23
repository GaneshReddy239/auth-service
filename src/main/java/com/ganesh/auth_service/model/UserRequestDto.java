package com.ganesh.auth_service.model;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserRequestDto {
    public enum Role {
        ADMIN,
        USER
    }
    private String username;

    private String email;

    private String password;
    @Enumerated(EnumType.STRING)
    private User.Role role;
}
