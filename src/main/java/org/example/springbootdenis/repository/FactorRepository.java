package org.example.springbootdenis.repository;

import org.example.springbootdenis.model.Factor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactorRepository extends JpaRepository<Factor,Integer> {
}
