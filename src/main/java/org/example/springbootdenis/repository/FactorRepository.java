package org.example.springbootdenis.repository;

import org.example.springbootdenis.model.Factor;
import org.example.springbootdenis.model.PAYED;
import org.example.springbootdenis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FactorRepository extends JpaRepository<Factor,Integer> {
    Optional<Factor> findByUserAndPayed(User user, PAYED payed);
}
