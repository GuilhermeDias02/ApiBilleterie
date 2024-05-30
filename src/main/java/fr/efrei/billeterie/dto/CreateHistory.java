package fr.efrei.billeterie.dto;

import fr.efrei.billeterie.model.Ticket;
import fr.efrei.billeterie.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;
import java.util.List;

public class CreateHistory {
    @Getter
    @NotNull
    private User user;

    @Getter
    @NotNull
    private Date date;

    @Getter
    @NotNull
    private float payed;

    @Getter
    @NotNull
    private List<Ticket> tickets;

    public CreateHistory(){}
    public CreateHistory(User user, Date date, float payed, List<Ticket> tickets){
        this.user = user;
        this.date = date;
        this.payed = payed;
        this.tickets = tickets;
    }
}
