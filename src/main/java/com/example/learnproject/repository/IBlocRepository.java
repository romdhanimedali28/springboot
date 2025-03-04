package com.example.learnproject.repository;

import com.example.learnproject.entities.Bloc;
import com.example.learnproject.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IBlocRepository extends JpaRepository<Bloc, Long> {
    @Query("SELECT b FROM Bloc b")
    List<Bloc> findAllBlocs();

    @Query("SELECT b FROM Bloc b WHERE b.idBloc = :id")
    Bloc findBlocById(Long id);

}
