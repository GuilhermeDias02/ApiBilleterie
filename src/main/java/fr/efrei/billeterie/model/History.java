package fr.efrei.billeterie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String uuid;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private float payed;

    @OneToMany
    private List<Ticket> tickets;

    public History(){}
    public History(User user, Date date, float payed, List<Ticket> tickets){
        this.user = user;
        this.date = date;
        this.payed = payed;
        this.tickets = tickets;
    }
}
