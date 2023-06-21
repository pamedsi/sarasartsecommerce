package com.example.sarasartsecommerce.entities;

import com.example.sarasartsecommerce.dto.signUpFormDTO;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;
    @Column (nullable = false, unique = true)
    private String login;
    @Column (nullable = false)
    private String password;
    @Column(updatable = false, unique = true, nullable = false)
    private String identifier;

    public User(){}

    public User(signUpFormDTO user){
        identifier = UUID.randomUUID().toString();
        login = user.getLogin();
        password = user.getPassword();
    }

    public Long getId() {
        return id;
    }
    public String getLogin() { return login; }
    public String getPassword() { return password; }
    public String getIdentifier() {return identifier;}

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

