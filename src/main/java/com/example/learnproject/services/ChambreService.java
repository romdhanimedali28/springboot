package com.example.learnproject.services;

import com.example.learnproject.entities.Chambre;
import com.example.learnproject.entities.TypeChambre;

import java.util.List;

public interface ChambreService {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre(Chambre c);
    Chambre retrieveChambre(long idChambre);
    void removeChambre(long idChambre);
    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type);
    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);
}
