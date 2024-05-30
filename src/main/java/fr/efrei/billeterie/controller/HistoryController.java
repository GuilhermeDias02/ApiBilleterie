package fr.efrei.billeterie.controller;

import fr.efrei.billeterie.dto.CreateHistory;
import fr.efrei.billeterie.dto.UpdateHistory;
import fr.efrei.billeterie.model.History;
import fr.efrei.billeterie.service.HistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/history")
public class HistoryController {

    private HistoryService service;

    @Autowired
    public HistoryController(HistoryService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<History>> findAll() {
        return new ResponseEntity<>(service.findAllHistories(), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<History> findOneById(@PathVariable String uuid) {
        History history = service.findHistoryById(uuid);
        if(history != null) {
            return new ResponseEntity<>(service.findHistoryById(uuid), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<History> save(@Valid @RequestBody CreateHistory history) {
        History createdHistory = service.create(history);
        return new ResponseEntity<>(createdHistory, HttpStatus.CREATED);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> delete(@PathVariable String uuid) {
        boolean isDeleted = service.delete(uuid);
        if(isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> mettreAJourTotalement(
            @PathVariable String uuid,
            @RequestBody UpdateHistory history) {
        boolean isUpdated = service.updateAll(uuid, history);
        if(isUpdated) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{uuid}/{ressource}")
    public ResponseEntity<?> mettreAjourPartiellement(
            @PathVariable String uuid,
            @PathVariable String ressource,
            @RequestBody UpdateHistory history) {
        boolean isUpdated = false;
        if(ressource.equals("price")){
            isUpdated = service.updatePayed(uuid, history);
        }
//        else if(ressource.equals("buyer")){
//            isUpdated = service.updateBuyer(uuid, ticket);
//        }

        if(isUpdated) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
