package fr.efrei.billeterie.dto;

import fr.efrei.billeterie.model.Ticket;
import fr.efrei.billeterie.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.Date;
import java.util.List;

public class CreateCart {
    @Getter
    @NotBlank
    private User user;

    @Getter
    @NotBlank
    private Date date;

    @Getter
    @NotBlank
    private float toPay;

    @Getter
    @NotBlank
    private List<Ticket> tickets;

    @Getter
    @NotBlank
    private boolean payed = false;

    public CreateCart(User user, Date date, float toPay, List<Ticket> tickets, boolean payed){
        this.user = user;
        this.date = date;
        this.toPay = toPay;
        this.tickets = tickets;
        this.payed = payed;
    }
    public CreateCart(User user, Date date, float toPay, List<Ticket> tickets){
        this.user = user;
        this.date = date;
        this.toPay = toPay;
        this.tickets = tickets;
    }

}
