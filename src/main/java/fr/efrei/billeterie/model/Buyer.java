package fr.efrei.billeterie.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private User user;

    @OneToMany
    @Column(nullable = false)
    private List<Ticket> tickets;
}