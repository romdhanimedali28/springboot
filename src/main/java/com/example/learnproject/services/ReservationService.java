package com.example.learnproject.services;

import com.example.learnproject.entities.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation addReservation(Reservation reservation);

    Reservation updateReservation(Reservation res);
    Reservation retrieveReservation(String idReservation);
    void removeReservation(String idReservation);
}
