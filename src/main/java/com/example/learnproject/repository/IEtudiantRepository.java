package com.example.learnproject.repository;

import com.example.learnproject.entities.Etudiant;
import com.example.learnproject.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface IEtudiantRepository extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findByCin(long cin);

}
