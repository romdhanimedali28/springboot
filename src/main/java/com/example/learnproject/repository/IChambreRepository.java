package com.example.learnproject.repository;

import com.example.learnproject.entities.Chambre;
import com.example.learnproject.entities.Foyer;
import com.example.learnproject.entities.TypeChambre;
import com.example.learnproject.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IChambreRepository extends JpaRepository<Chambre, Long> {
    @Query("SELECT c FROM Chambre c " +
            "WHERE c.bloc.foyer.universite = :universite " +
            "AND c.typeC = :type " +
            "AND c NOT IN (SELECT r.chambre FROM Reservation r WHERE r.estValide = true)")
    List<Chambre> findNonReservedChambresByUniversiteAndType(@Param("universite") Universite universite, @Param("type") TypeChambre type);
    @Query("SELECT c FROM Chambre c " +
            "WHERE c.bloc.idBloc = :idBloc " +
            "AND c.typeC = :typeC")
    List<Chambre> findByBlocIdAndTypeC(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);


}
