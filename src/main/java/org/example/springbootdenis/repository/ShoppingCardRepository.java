package org.example.springbootdenis.repository;

import org.example.springbootdenis.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCardRepository extends JpaRepository<ShoppingCard,Integer> {
}
