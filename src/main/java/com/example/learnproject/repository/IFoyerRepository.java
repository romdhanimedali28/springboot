package com.example.learnproject.repository;

import com.example.learnproject.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFoyerRepository extends JpaRepository<Foyer, Long> {
}