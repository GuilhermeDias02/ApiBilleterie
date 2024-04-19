package fr.efrei.billeterie.model;

import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String uuid;

    @ManyToOne
    @Column(nullable = false)
    private Event event;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private boolean discount;

    @ManyToOne
    @Column(nullable = true)
    private User buyer;
}
