package fr.efrei.billeterie.repository;

import fr.efrei.billeterie.controller.HistoryController;
import fr.efrei.billeterie.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoryRepository extends JpaRepository<History, String> {

    List<History> findAll();

    Optional<History> findOneByUuid(String uuid);

    History save(History history);

    void deleteByUuid(String Uuid);

}
