package com.example.learnproject.controllers;

import com.example.learnproject.entities.Chambre;
import com.example.learnproject.entities.TypeChambre;
import com.example.learnproject.services.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambres")
public class ChambreController {

    @Autowired
    private ChambreService chambreService;

    @GetMapping
    public ResponseEntity<List<Chambre>> retrieveAllChambres() {
        List<Chambre> chambres = chambreService.retrieveAllChambres();
        return ResponseEntity.ok(chambres);
    }

    @PostMapping
    public ResponseEntity<Chambre> addChambre(@RequestBody Chambre chambre) {
        Chambre savedChambre = chambreService.addChambre(chambre);
        return ResponseEntity.status(201).body(savedChambre); // 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chambre> updateChambre(@PathVariable long id, @RequestBody Chambre updatedChambre) {
        updatedChambre.setIdChambre(id);
        Chambre updated = chambreService.updateChambre(updatedChambre);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chambre> retrieveChambre(@PathVariable long id) {
        Chambre chambre = chambreService.retrieveChambre(id);
        if (chambre != null) {
            return ResponseEntity.ok(chambre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeChambre(@PathVariable long id) {
        chambreService.removeChambre(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/non-reserve")
    public ResponseEntity<List<Chambre>> getChambresNonReserveParNomUniversiteEtTypeChambre(
            @RequestParam String nomUniversite, @RequestParam TypeChambre type) {
        List<Chambre> chambres = chambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type);
        return ResponseEntity.ok(chambres);
    }


    @GetMapping("/by-bloc-type")
    public ResponseEntity<List<Chambre>> getChambresParBlocEtType(
            @RequestParam long idBloc, @RequestParam TypeChambre typeC) {
        List<Chambre> chambres = chambreService.getChambresParBlocEtType(idBloc, typeC);
        return ResponseEntity.ok(chambres);
    }




}