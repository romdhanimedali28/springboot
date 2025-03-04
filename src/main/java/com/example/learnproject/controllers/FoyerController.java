package com.example.learnproject.controllers;
import com.example.learnproject.entities.Foyer;
import com.example.learnproject.services.FoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foyers")
public class FoyerController {

    @Autowired
    private FoyerService foyerService;

    @GetMapping
    public ResponseEntity<List<Foyer>> retrieveAllFoyers() {
        List<Foyer> foyers = foyerService.retrieveAllFoyers();
        return ResponseEntity.ok(foyers);
    }

    @PostMapping
    public ResponseEntity<Foyer> addFoyer(@RequestBody Foyer foyer) {
        Foyer savedFoyer = foyerService.addFoyer(foyer);
        return ResponseEntity.status(201).body(savedFoyer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Foyer> updateFoyer(@PathVariable long id, @RequestBody Foyer updatedFoyer) {
        Foyer updated = foyerService.updateFoyer(updatedFoyer);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foyer> retrieveFoyer(@PathVariable long id) {
        Foyer foyer = foyerService.retrieveFoyer(id);
        if (foyer != null) {
            return ResponseEntity.ok(foyer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFoyer(@PathVariable long id) {
        foyerService.removeFoyer(id);
        return ResponseEntity.noContent().build();
    }
}