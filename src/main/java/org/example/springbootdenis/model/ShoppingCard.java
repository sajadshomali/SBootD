package org.example.springbootdenis.model;

import jakarta.persistence.*;

@Entity
public class ShoppingCard extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int count;
    @ManyToOne
    private Book book;
    @ManyToOne
    private Factor factor;
}
