package fr.efrei.billeterie.controller;

import fr.efrei.billeterie.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CartController {

    private CartService service;

    @Autowired
    public CartController(CartService service){
        this.service = service;
    }
}
