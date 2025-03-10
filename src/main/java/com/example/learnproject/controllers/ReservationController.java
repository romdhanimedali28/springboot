package com.example.learnproject.controllers;

import com.example.learnproject.entities.Reservation;
import com.example.learnproject.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<Reservation>> retrieveAllReservations() {
        List<Reservation> reservations = reservationService.retrieveAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        Reservation savedReservation = reservationService.addReservation(reservation);
        return ResponseEntity.status(201).body(savedReservation); // 201 Created
    }
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable String id, @RequestBody Reservation updatedReservation) {
        updatedReservation.setIdReservation(id); // Ensure the ID is set
        Reservation updated = reservationService.updateReservation(updatedReservation);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> retrieveReservation(@PathVariable String id) {
        Reservation reservation = reservationService.retrieveReservation(id);
        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeReservation(@PathVariable String id) {
        reservationService.removeReservation(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @GetMapping("/by-annee-universite")
    public ResponseEntity<List<Reservation>> getReservationParAnneeUniversitaireEtNomUniversite(
            @RequestParam Date anneeUniversite, @RequestParam String nomUniversite) {
        List<Reservation> reservations = reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite, nomUniversite);
        return ResponseEntity.ok(reservations);
    }

}