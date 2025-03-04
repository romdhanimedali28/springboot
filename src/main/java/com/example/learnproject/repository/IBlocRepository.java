package com.example.learnproject.repository;

import com.example.learnproject.entities.Bloc;
import com.example.learnproject.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IBlocRepository extends JpaRepository<Bloc, Long> {

}
