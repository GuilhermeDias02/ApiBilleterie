package fr.efrei.billeterie.dto;

import fr.efrei.billeterie.model.Ticket;
import fr.efrei.billeterie.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;
import java.util.List;

public class CreateCart {
    @Getter
    @NotNull
    private User user;

    @Getter
    @NotNull
    private Date date;

    @Getter
    @NotNull
    private float toPay;

    @Getter
    @NotNull
    private List<Ticket> tickets;

    @Getter
    @NotNull
    private boolean payed = false;

    public CreateCart(){}
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
