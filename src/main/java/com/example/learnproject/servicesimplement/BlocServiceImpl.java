package com.example.learnproject.servicesimplement;


import com.example.learnproject.entities.Bloc;
import com.example.learnproject.entities.Chambre;
import com.example.learnproject.repository.IBlocRepository;
import com.example.learnproject.repository.IChambreRepository;
import com.example.learnproject.services.BlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocServiceImpl implements BlocService {

    @Autowired
    private IBlocRepository blocRepository;
    @Autowired
    private IChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAllBlocs();
    }


    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public Bloc getBlocById(Long id) {
        return blocRepository.findBlocById(id);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }



    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc avec ID " + idBloc + " n'existe pas."));

        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);
        System.out.println(chambres);

        if (chambres.size() != numChambre.size()) {
            throw new RuntimeException("Certaines chambres spécifiées n'existent pas.");
        }

        for (Chambre chambre : chambres) {
            if (chambre.getBloc() != null) {
                throw new RuntimeException("La chambre " + chambre.getNumeroChambre() + " est déjà affectée à un bloc.");
            }
        }

        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }
        chambreRepository.saveAll(chambres);

        bloc.getChambres().addAll(chambres);
        return blocRepository.save(bloc);
    }
}