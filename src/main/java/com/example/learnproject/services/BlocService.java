package com.example.learnproject.services;

import com.example.learnproject.entities.Bloc;

import java.util.List;

public interface BlocService {
    List<Bloc> retrieveBlocs();
    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    Bloc retrieveBloc(long idBloc);
    void removeBloc(long idBloc);
}
