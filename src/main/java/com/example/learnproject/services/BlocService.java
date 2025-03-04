package com.example.learnproject.services;

import com.example.learnproject.entities.Bloc;

import java.util.List;

public interface BlocService {
    List<Bloc> retrieveBlocs();
    List<Bloc> getAllBlocs();
    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    Bloc retrieveBloc(long idBloc);
    Bloc getBlocById(Long id);
    void removeBloc(long idBloc);
}
