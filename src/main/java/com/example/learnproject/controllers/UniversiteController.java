package com.example.learnproject.controllers;

import com.example.learnproject.entities.Universite;
import com.example.learnproject.services.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universites")
public class UniversiteController {

    @Autowired
    private UniversiteService universiteService;

    @GetMapping
    public ResponseEntity<List<Universite>> retrieveAllUniversites() {
        List<Universite> universites = universiteService.retrieveAllUniversities();
        return ResponseEntity.ok(universites);
    }

    @PostMapping
    public ResponseEntity<Universite> addUniversite(@RequestBody Universite universite) {
        Universite savedUniversite = universiteService.addUniversite(universite);
        return ResponseEntity.status(201).body(savedUniversite); // 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<Universite> updateUniversite(@PathVariable long id, @RequestBody Universite updatedUniversite) {
        updatedUniversite.setIdUniversite(id); // Ensure the ID is set
        Universite updated = universiteService.updateUniversite(updatedUniversite);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Universite> retrieveUniversite(@PathVariable long id) {
        Universite universite = universiteService.retrieveUniversite(id);
        if (universite != null) {
            return ResponseEntity.ok(universite);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUniversite(@PathVariable long id) {
        universiteService.removeUniversite(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}