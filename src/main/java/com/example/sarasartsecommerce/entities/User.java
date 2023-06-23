package com.example.sarasartsecommerce.entities;

import com.example.sarasartsecommerce.dto.SignUpFormDTO;
import com.example.sarasartsecommerce.models.UserRole;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;
    @Column(updatable = false, unique = true, nullable = false)
    private String identifier;
    @Column (nullable = true)
    private String name;
    @Column (nullable = false, unique = true)
    private String email;
    @Column (nullable = true, unique = true)
    private String phoneNumber;
    @Column (nullable = false)
    private String password;
    @Column
    private UserRole userRole;
    @Column
    private LocalDate birthDate;
    @Column
    private LocalDateTime userSince;

    public User(){}

    public User(SignUpFormDTO user){
        name = user.getName();
        email = user.getEmail();
        if (user.getPhoneNumber() != null) phoneNumber = user.getPhoneNumber();
        identifier = UUID.randomUUID().toString();
        password = user.getPassword();
        userRole = UserRole.CLIENT;
        birthDate = LocalDate.parse(user.getBirthDate()); // "YYYY-MM-DD"
        userSince = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getPassword() { return password; }
    public String getIdentifier() {return identifier;}
    public void setPassword(String password) { this.password = password;}
}

