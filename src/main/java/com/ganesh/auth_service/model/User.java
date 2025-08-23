package com.ganesh.auth_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity(name="users")
public class User {
    public enum Role {
        ADMIN,
        USER
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    @NotBlank
    private String username;
    @Email
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    @Size(min=6)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    //Runs everytime an object is newly added
    @PrePersist
    public void createDate(){
        createdAt=LocalDateTime.now();
        updatedAt=LocalDateTime.now();
        status="active";
    }
    //Runs everytime an update is performed
    @PreUpdate
    public void updateDate(){
        updatedAt=LocalDateTime.now();
        status="active";
    }

}
