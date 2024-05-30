package fr.efrei.billeterie.repository;

import fr.efrei.billeterie.model.Event;
import fr.efrei.billeterie.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
    List<Event> findAll();

    Optional<Event> findOneByUuid(String uuid);
}