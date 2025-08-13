package com.ganesh.auth_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private String role;
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
