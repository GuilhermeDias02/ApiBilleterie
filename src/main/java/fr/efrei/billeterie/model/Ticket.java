package fr.efrei.billeterie.model;

import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String uuid;

    @ManyToOne
    private Event event;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private boolean discount;

    @ManyToOne
    private User user;

    public Ticket(Event event, float price, boolean discount, User user){
        this.event = event;
        this.price = price;
        this.discount = discount;
        this.user = user;
    }

    public String getUuid() {
        return uuid;
    }

    public Event getEvent() {
        return event;
    }

    public float getPrice() {
        return price;
    }

    public User getUser() {
        return user;
    }

    public void setEvent(Event event){
        this.event = event;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public void setDiscount(boolean discount){
        this.discount = discount;
    }
    public void setBuyer(User user){
        this.user = user;
    }
}
