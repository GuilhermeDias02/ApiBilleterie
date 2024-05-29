package fr.efrei.billeterie.dto;

import fr.efrei.billeterie.model.Event;
import fr.efrei.billeterie.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class CreateTicket {
    @Getter
    @NotBlank
    private Event event;

    @Getter
    @NotBlank
    private float price;

    @Getter
    @NotBlank
    private boolean discount = false;

    @Getter
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
}
