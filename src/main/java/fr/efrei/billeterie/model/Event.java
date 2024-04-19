package fr.efrei.billeterie.model;

import fr.efrei.billeterie.constants.SportFr;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String adress;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SportFr sport;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private int seats;

    @Column(nullable = false)
    private boolean opened;

    @Column(nullable = false)
    private boolean canceled;
}
