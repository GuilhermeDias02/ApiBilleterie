package fr.efrei.billeterie.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String uuid;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private float toPay;

    @OneToMany
    private List<Ticket> tickets;

    @Column(nullable = false)
    private boolean payed;

    public Order(User user, Date date, float toPay, List<Ticket> tickets, boolean payed){
        this.user = user;
        this.date = date;
        this.toPay = toPay;
        this.tickets = tickets;
        this.payed = payed;
    }
}
