package com.example.learnproject.repository;

import com.example.learnproject.entities.Chambre;
import com.example.learnproject.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IChambreRepository extends JpaRepository<Chambre, Long> {

}
