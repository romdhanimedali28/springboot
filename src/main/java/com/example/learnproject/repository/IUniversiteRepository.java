package com.example.learnproject.repository;

import com.example.learnproject.entities.Foyer;
import com.example.learnproject.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface IUniversiteRepository extends JpaRepository<Universite, Long> {
    @Query("SELECT u FROM Universite u WHERE u.nomUniversite = :nomUniversite")
    Optional<Universite> findByNomUniversite(@Param("nomUniversite") String nomUniversite);
}
