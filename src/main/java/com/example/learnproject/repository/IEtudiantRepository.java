package com.example.learnproject.repository;

import com.example.learnproject.entities.Etudiant;
import com.example.learnproject.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IEtudiantRepository extends JpaRepository<Etudiant, Long> {

    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants(List<Etudiant> etudiants);
    Etudiant updateEtudiant(Etudiant e);
    Etudiant retrieveEtudiant(long idEtudiant);
    void removeEtudiant(long idEtudiant);
}
