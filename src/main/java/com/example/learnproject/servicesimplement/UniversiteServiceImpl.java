package com.example.learnproject.servicesimplement;

import com.example.learnproject.entities.Foyer;
import com.example.learnproject.entities.Universite;
import com.example.learnproject.repository.IFoyerRepository;
import com.example.learnproject.repository.IUniversiteRepository;
import com.example.learnproject.services.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteServiceImpl implements UniversiteService {

    @Autowired
    private IUniversiteRepository universiteRepository;
    @Autowired
    private IFoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public void removeUniversite(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite getUniversiteByNom(String nomUniversite) {
        return universiteRepository.findByNomUniversite(nomUniversite)
                .orElseThrow(() -> new RuntimeException("Universite not found"));
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer introuvable avec ID : " + idFoyer));
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite)
                .orElseThrow(() -> new RuntimeException("Université introuvable avec le nom : " + nomUniversite));
        foyer.setUniversite(universite);
        return universiteRepository.save(universite);
    }


    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Universite not found"));
        Foyer foyer = universite.getFoyer();
        if (foyer != null) {
            foyer.setUniversite(null);
            universite.setFoyer(null);
            foyerRepository.save(foyer);
            universiteRepository.save(universite);
        }

        return universite;
    }




}