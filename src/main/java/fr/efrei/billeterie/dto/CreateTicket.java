package fr.efrei.billeterie.dto;

import fr.efrei.billeterie.model.Buyer;
import fr.efrei.billeterie.model.Event;
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
    private Buyer buyer = null;

    public CreateTicket(Event event, float price){
        this.event = event;
        this.price = price;
    }
    public CreateTicket(Event event, float price, boolean discount){
        this.event = event;
        this.price = price;
        this.discount = discount;
    }
    public CreateTicket(Event event, float price, Buyer buyer){
        this.event = event;
        this.price = price;
        this.buyer = buyer;
    }
    public CreateTicket(Event event, float price, boolean discount, Buyer buyer){
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

    public Buyer getBuyer() {
        return buyer;
    }
}
