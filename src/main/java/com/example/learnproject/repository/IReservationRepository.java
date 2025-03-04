package com.example.learnproject.repository;

import com.example.learnproject.entities.Foyer;
import com.example.learnproject.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IReservationRepository extends JpaRepository<Reservation, String> {

}
