package fr.efrei.billeterie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Cart {
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
    private boolean payed = false;

    public Cart(User user, Date date, float toPay, List<Ticket> tickets, boolean payed){
        this.user = user;
        this.date = date;
        this.toPay = toPay;
        this.tickets = tickets;
        this.payed = payed;
    }
    public Cart(User user, Date date, float toPay, List<Ticket> tickets){
        this.user = user;
        this.date = date;
        this.toPay = toPay;
        this.tickets = tickets;
    }
}
