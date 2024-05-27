package fr.efrei.billeterie.dto;

import fr.efrei.billeterie.model.Event;
import fr.efrei.billeterie.model.User;
import jakarta.validation.constraints.NotBlank;

public class UpdateTicket {
    @NotBlank
    private Event event;

    @NotBlank
    private float price;

    @NotBlank
    private boolean discount = false;

    @NotBlank
    private User buyer = null;

    public UpdateTicket(float price, boolean discount, User buyer){
        this.price = price;
        this.discount = discount;
        this.buyer = buyer;
    }

    public Event getEvent(){
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
