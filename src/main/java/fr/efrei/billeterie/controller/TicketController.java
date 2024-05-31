package fr.efrei.billeterie.controller;

import fr.efrei.billeterie.dto.CreateTicket;
import fr.efrei.billeterie.dto.UpdateTicket;
import fr.efrei.billeterie.model.Ticket;
import fr.efrei.billeterie.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@EnableMethodSecurity
public class TicketController {

    private final TicketService service;

    @Autowired
    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> findAll() {
        return new ResponseEntity<>(service.findAllTickets(), HttpStatus.OK);
    }

    @GetMapping("/find/{uuid}")
    public ResponseEntity<Ticket> findOneById(@PathVariable String uuid) {
        Ticket ticket = service.findTicketById(uuid);
        if(ticket != null) {
            return new ResponseEntity<>(service.findTicketById(uuid), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/count/{uuid}")
    public ResponseEntity<Long> countById(@PathVariable String uuid){
        Long count = service.countTicketByEvent(uuid);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Ticket> save(@Valid @RequestBody CreateTicket ticket) {
        Ticket createdTicket = service.create(ticket);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> delete(@PathVariable String uuid) {
        boolean isDeleted = service.delete(uuid);
        if(isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{uuid}")
    public ResponseEntity<?> mettreAJourTotalement(
            @PathVariable String uuid,
            @RequestBody UpdateTicket ticket) {
        boolean isUpdated = service.updateAll(uuid, ticket);
        if(isUpdated) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/{uuid}/{ressource}")
    public ResponseEntity<?> mettreAjourPartiellement(
            @PathVariable String uuid,
            @PathVariable String ressource,
            @RequestBody UpdateTicket ticket) {
        boolean isUpdated = false;
        if(ressource.equals("price")){
            isUpdated = service.updateDiscount(uuid, ticket);
        }
        else if(ressource.equals("buyer")){
            isUpdated = service.updateBuyer(uuid, ticket);
        }

        if(isUpdated) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
