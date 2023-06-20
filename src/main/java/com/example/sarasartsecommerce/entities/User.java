package com.example.sarasartsecommerce.entities;

import com.example.sarasartsecommerce.dto.signUpFormDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;
    @Column (nullable = false)
    private String login;
    @Column (nullable = false)
    private String password;

    public User(){}

    public User(signUpFormDTO user){
        login = user.getLogin();
        password = user.getPassword();
    }

    public Long getId() {
        return id;
    }
    public String getLogin() { return login; }
    public String getPassword() { return password; }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
