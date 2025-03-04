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
        System.out.println("Retrieved Foyers:");
        for (Foyer foyer : foyers) {
            System.out.println("Foyer: " + foyer.getNomFoyer());
        }
        return ResponseEntity.ok(foyers);
    }

    @PostMapping
    public ResponseEntity<Foyer> addFoyer(@RequestBody Foyer foyer) {
        System.out.println("Foyer: " + foyer.getNomFoyer());
        Foyer savedFoyer = foyerService.addFoyer(foyer);
        System.out.println("Foyer: " + savedFoyer.getNomFoyer());
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