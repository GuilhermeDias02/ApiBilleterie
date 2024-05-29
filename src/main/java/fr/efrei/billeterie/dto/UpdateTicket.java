package fr.efrei.billeterie.dto;

import fr.efrei.billeterie.model.Event;
import fr.efrei.billeterie.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class UpdateTicket {
    @Getter
    @NotBlank
    private Event event;

    @lombok.Getter
    @NotBlank
    private float price;

    @Getter
    @NotBlank
    private boolean discount = false;

    @Getter
    @NotBlank
    private User buyer = null;

    public UpdateTicket(float price, boolean discount, User buyer){
        this.price = price;
        this.discount = discount;
        this.buyer = buyer;
    }
}
