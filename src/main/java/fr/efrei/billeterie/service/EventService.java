package fr.efrei.billeterie.service;

import fr.efrei.billeterie.model.Event;
import fr.efrei.billeterie.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private EventRepository repository;

    @Autowired
    public EventService(EventRepository repository){
        this.repository = repository;
    }

    public List<Event> findAllEvents() {
        return repository.findAll();
    }

    public Event findEventById(String uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }
}
