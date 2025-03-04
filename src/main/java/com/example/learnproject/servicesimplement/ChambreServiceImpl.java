package com.example.learnproject.servicesimplement;

import com.example.learnproject.entities.Chambre;
import com.example.learnproject.repository.IChambreRepository;
import com.example.learnproject.services.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreServiceImpl implements ChambreService {

    @Autowired
    private IChambreRepository chambreRepository;

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