package com.example.learnproject.services;

import com.example.learnproject.entities.Universite;

import java.util.List;

public interface UniversiteService {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite(Universite u);
    Universite updateUniversite(Universite u);
    Universite retrieveUniversite(long idUniversite);
    void removeUniversite(long idUniversite);
    Universite getUniversiteByNom(String nomUniversite);
    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);
    Universite desaffecterFoyerAUniversite(long idUniversite);

}
