package fr.efrei.billeterie.controller;

import fr.efrei.billeterie.model.Event;
import fr.efrei.billeterie.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/event")
@RestController
@Controller
public class EventController {
    private EventService service;

    @Autowired
    public EventController(EventService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Event>> findAll() {
        return new ResponseEntity<>(service.findAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Event> findOneById(@PathVariable String uuid) {
        Event event = service.findEventById(uuid);
        if(event != null) {
            return new ResponseEntity<>(service.findEventById(uuid), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
