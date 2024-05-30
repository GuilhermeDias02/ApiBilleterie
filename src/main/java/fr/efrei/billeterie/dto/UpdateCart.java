package fr.efrei.billeterie.dto;

import fr.efrei.billeterie.model.Ticket;
import lombok.Getter;

import java.util.List;

public class UpdateCart {
    @Getter
    private float toPay;

    @Getter
    private List<Ticket> tickets;

    @Getter
    private boolean payed = false;

    public UpdateCart(){}
    public UpdateCart(float toPay, List<Ticket> tickets, boolean payed){
        this.toPay = toPay;
        this.tickets = tickets;
        this.payed = payed;
    }
}
