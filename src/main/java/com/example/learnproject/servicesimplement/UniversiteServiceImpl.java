package com.example.learnproject.servicesimplement;

import com.example.learnproject.entities.Universite;
import com.example.learnproject.repository.IUniversiteRepository;
import com.example.learnproject.services.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteServiceImpl implements UniversiteService {

    @Autowired
    private IUniversiteRepository universiteRepository;

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
}