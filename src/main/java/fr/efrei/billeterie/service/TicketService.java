package fr.efrei.billeterie.service;

import fr.efrei.billeterie.dto.CreateTicket;
import fr.efrei.billeterie.model.Ticket;
import fr.efrei.billeterie.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository repository;

    @Autowired
    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public List<Ticket> findAllTickets() {
        return repository.findAll();
    }

    public Ticket findTicketById(String uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }

    public Ticket create(CreateTicket ticket) {
        Ticket ticketACreer = new Ticket(
                ticket.getEvent(),
                ticket.getPrice(),
                ticket.isDiscount(),
                ticket.getBuyer()
        );
        return repository.save(ticketACreer);
    }

//    @Transactional
//    public boolean delete(String uuid) {
//        Student studentASupprimer = findStudentById(uuid);
//        if(studentASupprimer != null && studentASupprimer.getDeletedAt() == null) {
//            studentASupprimer.setDeletedAt(LocalDateTime.now());
//            repository.save(studentASupprimer);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean update(String uuid, UpdateStudent student) {
//        Student studentAModifier = findStudentById(uuid);
//
//        if(studentAModifier != null) {
//            studentAModifier.setFirstname(student.getFirstname());
//            studentAModifier.setName(student.getName());
//            repository.save(studentAModifier);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean updatePartielle(String uuid, UpdateStudent student) {
//        Student studentAModifier = findStudentById(uuid);
//
//        if(studentAModifier != null) {
//            if(!student.getFirstname().isEmpty()) {
//                studentAModifier.setFirstname(student.getFirstname());
//            }
//            if(!student.getName().isEmpty()) {
//                studentAModifier.setName(student.getName());
//            }
//            repository.save(studentAModifier);
//            return true;
//        }
//        return false;
//    }
}
