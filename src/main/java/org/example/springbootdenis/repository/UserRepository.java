package org.example.springbootdenis.repository;

import org.example.springbootdenis.dto.request.UserRequest;
import org.example.springbootdenis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
