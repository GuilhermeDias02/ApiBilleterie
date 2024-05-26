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
    private Buyer buyer;

    public Ticket(Event event, float price, boolean discount, Buyer buyer){
        this.event = event;
        this.price = price;
        this.discount = discount;
        this.buyer = buyer;
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

    public Buyer getBuyer() {
        return buyer;
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
    public void setBuyer(Buyer buyer){
        this.buyer = buyer;
    }
}
