package fr.efrei.billeterie.service;

import fr.efrei.billeterie.model.Cart;
import fr.efrei.billeterie.repository.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private CartRepository repository;

    @Autowired
    public CartService(CartRepository repository){
        this.repository = repository;
    }

    public List<Cart> findAllCarts() {
        return repository.findAll();
    }

    public Cart findCartById(String uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }

    public Cart create(CreateCart cart) {
        Cart cartACreer = new Cart(
                ticket.getEvent(),
                ticket.getPrice(),
                ticket.isDiscount(),
                ticket.getBuyer()
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
            ticketAModifier.setBuyer(ticket.getBuyer());
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
                ticketAModifier.setBuyer(ticket.getBuyer());
            }
            repository.save(ticketAModifier);
            return true;
        }
        return false;
    }

}
