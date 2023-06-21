package com.example.sarasartsecommerce.repositories;

import com.example.sarasartsecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long>{
    List <User> findSingleByLogin(String login);
}
