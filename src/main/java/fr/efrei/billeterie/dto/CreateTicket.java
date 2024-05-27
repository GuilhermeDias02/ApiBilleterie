package fr.efrei.billeterie.dto;

import fr.efrei.billeterie.model.Event;
import fr.efrei.billeterie.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateTicket {
    @NotBlank
    private Event event;

    @NotBlank
    private float price;

    @NotBlank
    private boolean discount = false;

    @NotBlank
    private User buyer = null;

    public CreateTicket(Event event, float price){
        this.event = event;
        this.price = price;
    }
    public CreateTicket(Event event, float price, boolean discount){
        this.event = event;
        this.price = price;
        this.discount = discount;
    }
    public CreateTicket(Event event, float price, User buyer){
        this.event = event;
        this.price = price;
        this.buyer = buyer;
    }
    public CreateTicket(Event event, float price, boolean discount, User buyer){
        this.event = event;
        this.price = price;
        this.discount = discount;
        this.buyer = buyer;
    }

    public Event getEvent() {
        return event;
    }

    public float getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public User getBuyer() {
        return buyer;
    }
}
