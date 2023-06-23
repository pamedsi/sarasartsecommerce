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
    @Column (nullable = false, unique = true)
    private String email;
    @Column (nullable = true, unique = true)
    private String phoneNumber;
    @Column (nullable = false)
    private String password;
    @Column
    private LocalDate birthDate;
    @Column (updatable = false)
    private LocalDateTime userSince;
    @ManyToMany
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List <Address> addresses;

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

    public void setPassword(String password) { this.password = password;}
}

