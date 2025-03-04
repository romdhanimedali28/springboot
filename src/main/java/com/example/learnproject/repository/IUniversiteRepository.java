package com.example.learnproject.repository;

import com.example.learnproject.entities.Foyer;
import com.example.learnproject.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IUniversiteRepository extends JpaRepository<Universite, Long> {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite(Universite u);
    Universite updateUniversite(Universite u);
    Universite retrieveUniversite(long idUniversite);
}
