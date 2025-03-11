package com.example.learnproject.servicesimplement;

import com.example.learnproject.entities.Bloc;
import com.example.learnproject.entities.Foyer;
import com.example.learnproject.entities.Universite;
import com.example.learnproject.repository.IFoyerRepository;
import com.example.learnproject.repository.IUniversiteRepository;
import com.example.learnproject.services.FoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class FoyerServiceImpl implements FoyerService {

    @Autowired
    private IFoyerRepository foyerRepository;

    @Autowired
    private IUniversiteRepository universiteRepository;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }


    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Universite not found"));

        foyer.setUniversite(universite);

        for (Bloc bloc : foyer.getBlocs()) {
            bloc.setFoyer(foyer);
        }

        return foyerRepository.save(foyer);
    }
}
