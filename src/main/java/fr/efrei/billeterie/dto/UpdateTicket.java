package fr.efrei.billeterie.dto;

import fr.efrei.billeterie.model.Buyer;
import fr.efrei.billeterie.model.Event;
import jakarta.validation.constraints.NotBlank;

public class UpdateTicket {
    @NotBlank
    private Event event;

    @NotBlank
    private float price;

    @NotBlank
    private boolean discount = false;

    @NotBlank
    private Buyer buyer = null;

    public UpdateTicket(float price, boolean discount, Buyer buyer){
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

    public Buyer getBuyer() {
        return buyer;
    }
}
