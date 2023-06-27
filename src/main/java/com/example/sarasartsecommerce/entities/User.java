package com.example.sarasartsecommerce.entities;

import com.example.sarasartsecommerce.dto.SignUpFormDTO;
import com.example.sarasartsecommerce.models.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (updatable = false, unique = true, nullable = false)
    private Long id;
    @Column (updatable = false, unique = true, nullable = false)
    private String identifier;
    @Column (nullable = false)
    private UserRole userRole;
    @Column (nullable = false)
    private String name;
    @Column
    private String username;
    @Column (nullable = false, unique = true)
    private String email;
    @Column (unique = true)
    private String phoneNumber;
    @Column (nullable = false)
    private String password;
    @Column
    private LocalDate birthDate;
    @Column (updatable = false)
    private LocalDateTime userSince;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserSince(LocalDateTime userSince) {
        this.userSince = userSince;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @ManyToMany
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List <Address> addresses;
    private Boolean active;

    public User(SignUpFormDTO user){
        name = user.name();
        email = user.email();
        if (user.phoneNumber() != null) phoneNumber = user.phoneNumber();
        identifier = UUID.randomUUID().toString();
        password = user.password();
        userRole = UserRole.CLIENT;
        birthDate = user.birthDate(); // "YYYY-MM-DD"
        userSince = LocalDateTime.now();
        active = true;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setPassword(String password) { this.password = password;}
}

