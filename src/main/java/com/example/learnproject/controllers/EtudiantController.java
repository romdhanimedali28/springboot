package com.example.learnproject.controllers;
import com.example.learnproject.entities.Etudiant;
import com.example.learnproject.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public ResponseEntity<List<Etudiant>> retrieveAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.retrieveAllEtudiants();
        return ResponseEntity.ok(etudiants);
    }

    @PostMapping
    public ResponseEntity<List<Etudiant>> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        List<Etudiant> savedEtudiants = etudiantService.addEtudiants(etudiants);
        return ResponseEntity.status(201).body(savedEtudiants);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable long id, @RequestBody Etudiant updatedEtudiant) {
        Etudiant updated = etudiantService.updateEtudiant(updatedEtudiant);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> retrieveEtudiant(@PathVariable long id) {
        Etudiant etudiant = etudiantService.retrieveEtudiant(id);
        if (etudiant != null) {
            return ResponseEntity.ok(etudiant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeEtudiant(@PathVariable long id) {
        etudiantService.removeEtudiant(id);
        return ResponseEntity.noContent().build();
    }
}