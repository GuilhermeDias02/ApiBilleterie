package fr.efrei.billeterie.controller;

import fr.efrei.billeterie.dto.CreateCart;
import fr.efrei.billeterie.dto.UpdateCart;
import fr.efrei.billeterie.model.Cart;
import fr.efrei.billeterie.service.CartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@EnableMethodSecurity
@Controller
public class CartController {

    private CartService service;

    @Autowired
    public CartController(CartService service){
        this.service = service;
    }

//    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Buyer')")
    @GetMapping
    public ResponseEntity<List<Cart>> findAll() {
        return new ResponseEntity<>(service.findAllCarts(), HttpStatus.OK);
    }


//    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Buyer')")
    @GetMapping("/{uuid}")
    public ResponseEntity<Cart> findOneById(@PathVariable String uuid) {
        Cart cart = service.findCartById(uuid);
        if(cart != null) {
            return new ResponseEntity<>(service.findCartById(uuid), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Buyer')")
    @PostMapping
    public ResponseEntity<Cart> save(@Valid @RequestBody CreateCart cart) {
        Cart createdCart = service.create(cart);
        return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
    }

//    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Buyer')")
    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> delete(@PathVariable String uuid) {
        boolean isDeleted = service.delete(uuid);
        if(isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Buyer')")
    @PutMapping("/{uuid}")
    public ResponseEntity<?> mettreAJourTotalement(
            @PathVariable String uuid,
            @RequestBody UpdateCart cart) {
        boolean isUpdated = service.updateAll(uuid, cart);
        if(isUpdated) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Buyer')")
    @PatchMapping("/{uuid}/{ressource}")
    public ResponseEntity<?> mettreAjourPartiellement(
            @PathVariable String uuid,
            @PathVariable String ressource,
            @RequestBody UpdateCart cart) {
        boolean isUpdated = false;
        if(ressource.equals("price")){
            isUpdated = service.updateTotalPrice(uuid, cart);
        }
//        else if(ressource.equals("buyer")){
//            isUpdated = service.updateBuyer(uuid, ticket);
//        }

        if(isUpdated) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
