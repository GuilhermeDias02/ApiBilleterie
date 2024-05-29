package fr.efrei.billeterie.service;

import fr.efrei.billeterie.dto.CreateCart;
import fr.efrei.billeterie.dto.UpdateCart;
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
                cart.getUser(),
                cart.getDate(),
                cart.getToPay(),
                cart.getTickets(),
                cart.isPayed()
        );
        return repository.save(cartACreer);
    }

    @Transactional
    public boolean delete(String uuid) {
        Cart CartASupprimer = findCartById(uuid);
        if(CartASupprimer != null) {
            repository.deleteByUuid(uuid);
            return true;
        }
        return false;
    }

    public boolean updateAll(String uuid, UpdateCart cart){
        Cart cartAModifier = findCartById(uuid);

        if(cartAModifier != null) {
            cartAModifier.setToPay(cart.getToPay());
            cartAModifier.setTickets(cart.getTickets());
            cartAModifier.setPayed(cart.isPayed());
            repository.save(cartAModifier);
            return true;
        }
        return false;
    }

    public boolean updateTotalPrice(String uuid, UpdateCart cart) {
        Cart cartAModifier = findCartById(uuid);

        if(cartAModifier != null) {
            cartAModifier.setToPay(cart.getToPay());
            repository.save(cartAModifier);
            return true;
        }
        return false;
    }
}
