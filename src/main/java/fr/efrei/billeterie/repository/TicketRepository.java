package fr.efrei.billeterie.repository;

import fr.efrei.billeterie.model.Event;
import fr.efrei.billeterie.model.Ticket;
import fr.efrei.billeterie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

    List<Ticket> findAll();

    @Query(value = "SELECT COUNT(*) FROM ticket WHERE event_uuid = ?1", nativeQuery = true)
    List<Ticket> CountByEvent(String event_uuid);

    Optional<Ticket> findAllByUser(User user);

    Optional<Ticket> findOneByUuid(String uuid);

    Ticket save(Ticket ticket);

    void deleteByUuid(String Uuid);

}
