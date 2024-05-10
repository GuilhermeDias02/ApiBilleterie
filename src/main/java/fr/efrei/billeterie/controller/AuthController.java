package fr.efrei.billeterie.controller;

import fr.efrei.billeterie.security.AuthConfiguration;
import fr.efrei.billeterie.security.JwtService;
import fr.efrei.billeterie.service.AuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController {
    private final JwtService jwtService;
    private final AuthService authenticationService;

    public AuthController(JwtService jwtService, AuthService authenticationService){
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

}
