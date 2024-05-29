package fr.efrei.billeterie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Ticket {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String uuid;

    @Setter
    @Getter
    @ManyToOne
    private Event event;

    @Setter
    @Getter
    @Column(nullable = false)
    private float price;

    @Setter
    @Column(nullable = false)
    private boolean discount;

    @Setter
    @Getter
    @ManyToOne
    private User user;

    public Ticket(Event event, float price, boolean discount, User user){
        this.event = event;
        this.price = price;
        this.discount = discount;
        this.user = user;
    }
}
