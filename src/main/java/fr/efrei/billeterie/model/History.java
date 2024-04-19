package fr.efrei.billeterie.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private User user;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private float priceTotal;

    @OneToOne
    @Column(nullable = false)
    private List<Ticket> tickets;
}