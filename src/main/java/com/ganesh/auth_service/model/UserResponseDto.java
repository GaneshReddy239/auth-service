package com.ganesh.auth_service.model;


import lombok.*;

import java.time.LocalDateTime;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private User.Role role;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
