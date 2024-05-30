package fr.efrei.billeterie.service;

import fr.efrei.billeterie.dto.CreateHistory;
import fr.efrei.billeterie.dto.UpdateHistory;
import fr.efrei.billeterie.model.History;
import fr.efrei.billeterie.repository.HistoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    private final HistoryRepository repository;

    @Autowired
    public HistoryService(HistoryRepository repository) {
        this.repository = repository;
    }

    public List<History> findAllHistories() {
        return repository.findAll();
    }

    public History findHistoryById(String uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }

    public History create(CreateHistory history) {
        History historyACreer = new History(
                history.getUser(),
                history.getDate(),
                history.getPayed(),
                history.getTickets()
        );
        return repository.save(historyACreer);
    }

    @Transactional
    public boolean delete(String uuid) {
        History historyASupprimer = findHistoryById(uuid);
        if(historyASupprimer != null) {
            repository.deleteByUuid(uuid);
            return true;
        }
        return false;
    }

    public boolean updateAll(String uuid, UpdateHistory history){
        History historyAModifier = findHistoryById(uuid);

        if(historyAModifier != null) {
            historyAModifier.setPayed(history.getPayed());
            historyAModifier.setTickets(history.getTickets());
            repository.save(historyAModifier);
            return true;
        }
        return false;
    }

    public boolean updatePayed(String uuid, UpdateHistory history) {
        History historyAModifier = findHistoryById(uuid);

        if(historyAModifier != null) {
            historyAModifier.setPayed(history.getPayed());
            repository.save(historyAModifier);
            return true;
        }
        return false;
    }
}
