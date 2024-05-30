package fr.efrei.billeterie.dto;

import fr.efrei.billeterie.model.Ticket;
import lombok.Getter;

import java.util.List;

public class UpdateHistory {
    @Getter
    private float payed;

    @Getter
    private List<Ticket> tickets;

    public UpdateHistory(){}
    public UpdateHistory(float payed, List<Ticket> tickets){
        this.payed = payed;
        this.tickets = tickets;
    }
}
