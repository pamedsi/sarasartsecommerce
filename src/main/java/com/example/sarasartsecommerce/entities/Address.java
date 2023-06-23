package com.example.sarasartsecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;
    @Column(updatable = false, unique = true, nullable = false)
    private String identifier;
    private String Logradouro;
    private String nomeDoLogradouro;
    private String numero;
    private String complemento;
    private String CEP;
    private String bairro;
    private String municipio;
    private String estado;
    private String pais;
    private LocalDate registeredAt;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "user_id")
    private List<User> users;

    public Address() {
        this.identifier = UUID.randomUUID().toString();
    }

    // Getters e setters
}

