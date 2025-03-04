package com.example.learnproject.repository;

import com.example.learnproject.entities.Bloc;
import com.example.learnproject.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IBlocRepository extends JpaRepository<Bloc, Long> {
    List<Bloc> retrieveBlocs();
    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    Bloc retrieveBloc(long idBloc);
    void removeBloc(long idBloc);
}
