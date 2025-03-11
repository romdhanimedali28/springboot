package com.example.learnproject.services;

import com.example.learnproject.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation addReservation(Reservation reservation);

    Reservation updateReservation(Reservation res);
    Reservation retrieveReservation(String idReservation);
    void removeReservation(String idReservation);

    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite);
    Reservation ajouterReservation(long idBloc, long cinEtudiant);
}
