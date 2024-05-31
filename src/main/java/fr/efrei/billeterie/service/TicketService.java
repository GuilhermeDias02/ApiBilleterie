package fr.efrei.billeterie.service;

import fr.efrei.billeterie.dto.CreateTicket;
import fr.efrei.billeterie.dto.UpdateTicket;
import fr.efrei.billeterie.model.Event;
import fr.efrei.billeterie.model.Ticket;
import fr.efrei.billeterie.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository repository;
    private EventService eventService;

    @Autowired
    public TicketService(TicketRepository repository, EventService eventService) {
        this.repository = repository;
        this.eventService = eventService;
    }

    public List<Ticket> findAllTickets() {
        return repository.findAll();
    }

    public Ticket findTicketById(String uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }

    public Long countTicketByEvent(String uuid){
        Event event = eventService.findEventById(uuid);
        return repository.countByEvent(event);
    }

    public Ticket create(CreateTicket ticket) {
        Ticket ticketACreer = new Ticket(
                ticket.getEvent(),
                ticket.getPrice(),
                ticket.isDiscount(),
                ticket.getUser()
        );
        return repository.save(ticketACreer);
    }

    @Transactional
    public boolean delete(String uuid) {
        Ticket ticketASupprimer = findTicketById(uuid);
        if(ticketASupprimer != null) {
            repository.deleteByUuid(uuid);
            return true;
        }
        return false;
    }

    public boolean updateAll(String uuid, UpdateTicket ticket){
        Ticket ticketAModifier = findTicketById(uuid);

        if(ticketAModifier != null) {
            ticketAModifier.setEvent(ticket.getEvent());
            ticketAModifier.setPrice(ticket.getPrice());
            ticketAModifier.setDiscount(ticket.isDiscount());
            ticketAModifier.setUser(ticket.getBuyer());
            repository.save(ticketAModifier);
            return true;
        }
        return false;
    }

    public boolean updateDiscount(String uuid, UpdateTicket ticket) {
        Ticket ticketAModifier = findTicketById(uuid);

        if(ticketAModifier != null) {
            ticketAModifier.setPrice(ticket.getPrice());
            ticketAModifier.setDiscount(ticket.isDiscount());
            repository.save(ticketAModifier);
            return true;
        }
        return false;
    }

    public boolean updateBuyer(String uuid, UpdateTicket ticket) {
        Ticket ticketAModifier = findTicketById(uuid);

        if(ticketAModifier != null) {
            if(ticket.getBuyer() != null) {
                ticketAModifier.setUser(ticket.getBuyer());
            }
            repository.save(ticketAModifier);
            return true;
        }
        return false;
    }
}
