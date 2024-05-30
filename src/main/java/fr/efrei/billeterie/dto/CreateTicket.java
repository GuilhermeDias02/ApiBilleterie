package fr.efrei.billeterie.dto;

import fr.efrei.billeterie.model.Event;
import fr.efrei.billeterie.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class CreateTicket {
    @Getter
//    @NotNull
    private Event event;

    @Getter
    @NotNull
    private float price;

    @Getter
    @NotNull
    private boolean discount = false;

    @Getter
    private User user = null;

    public CreateTicket(){}
    public CreateTicket(Event event, float price){
        this.event = event;
        this.price = price;
    }
    public CreateTicket(Event event, float price, boolean discount){
        this.event = event;
        this.price = price;
        this.discount = discount;
    }
    public CreateTicket(Event event, float price, User user){
        this.event = event;
        this.price = price;
        this.user = user;
    }
    public CreateTicket(Event event, float price, boolean discount, User user){
        this.event = event;
        this.price = price;
        this.discount = discount;
        this.user = user;
    }
}
