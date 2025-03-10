package com.example.learnproject.servicesimplement;

import com.example.learnproject.entities.Chambre;
import com.example.learnproject.entities.TypeChambre;
import com.example.learnproject.entities.Universite;
import com.example.learnproject.repository.IChambreRepository;
import com.example.learnproject.repository.IUniversiteRepository;
import com.example.learnproject.services.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreServiceImpl implements ChambreService {

    @Autowired
    private IChambreRepository chambreRepository;
    @Autowired
    private IUniversiteRepository universiteRepository;

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite)
                .orElseThrow(() -> new RuntimeException("Universite not found"));

        return chambreRepository.findNonReservedChambresByUniversiteAndType(universite, type);
    }


    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBlocIdAndTypeC(idBloc, typeC);
    }

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public void removeChambre(long idChambre) {
        if (chambreRepository.existsById(idChambre)) {
            chambreRepository.deleteById(idChambre);
        } else {
            throw new IllegalArgumentException("Chambre with ID " + idChambre + " does not exist");
        }
    }
}