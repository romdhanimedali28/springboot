package com.example.learnproject.repository;

import com.example.learnproject.entities.Foyer;
import com.example.learnproject.entities.Reservation;
import com.example.learnproject.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface IReservationRepository extends JpaRepository<Reservation, String> {
    @Query("SELECT r FROM Reservation r " +
            "WHERE r.anneeUniversitaire = :anneeUniversitaire " +
            "AND r.chambre.bloc.foyer.universite = :universite")
    List<Reservation> findByAnneeUniversitaireAndChambreBlocFoyerUniversite(
            @Param("anneeUniversitaire") Date anneeUniversitaire,
            @Param("universite") Universite universite);
}
