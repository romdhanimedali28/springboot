package com.example.learnproject.servicesimplement;


import com.example.learnproject.entities.Bloc;
import com.example.learnproject.repository.IBlocRepository;
import com.example.learnproject.services.BlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocServiceImpl implements BlocService {

    @Autowired
    private IBlocRepository blocRepository;

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
}