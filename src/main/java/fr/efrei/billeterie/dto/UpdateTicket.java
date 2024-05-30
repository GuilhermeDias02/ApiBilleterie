package fr.efrei.billeterie.dto;

import fr.efrei.billeterie.model.Event;
import fr.efrei.billeterie.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class UpdateTicket {
    @Getter
    @NotNull
    private Event event;

    @Getter
    @NotNull
    private float price;

    @Getter
    @NotNull
    private boolean discount = false;

    @Getter
    @NotNull
    private User buyer = null;

    public UpdateTicket(float price, boolean discount, User buyer){
        this.price = price;
        this.discount = discount;
        this.buyer = buyer;
    }
}
