package com.example.learnproject.servicesimplement;

import com.example.learnproject.entities.*;
import com.example.learnproject.repository.IBlocRepository;
import com.example.learnproject.repository.IEtudiantRepository;
import com.example.learnproject.repository.IReservationRepository;
import com.example.learnproject.repository.IUniversiteRepository;
import com.example.learnproject.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private IReservationRepository reservationRepository;

    @Autowired
    private IUniversiteRepository universiteRepository;

    @Autowired
    private IBlocRepository blocRepository;

    @Autowired
    private IEtudiantRepository etudiantRepository;
    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite)
                .orElseThrow(() -> new RuntimeException("Universite not found"));

        return reservationRepository.findByAnneeUniversitaireAndChambreBlocFoyerUniversite(anneeUniversite, universite);
    }

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }
    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public void removeReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }


    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc introuvable avec l'id : " + idBloc));

        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable avec le CIN : " + cinEtudiant));

        for (Chambre chambre : bloc.getChambres()) {
            long reservationsCount = chambre.getReservations().stream()
                    .flatMap(reservation -> reservation.getEtudiants().stream())
                    .count();

            long maxCapacity = getCapacityByType(chambre.getTypeC());
            if (reservationsCount < maxCapacity) {
                String idReservation = generateIdReservation(chambre, bloc);
                Date anneeUniversitaire = new Date();
                Reservation reservation = new Reservation();
                reservation.setIdReservation(idReservation);
                reservation.setAnneeUniversitaire(anneeUniversitaire);
                reservation.setEstValide(true);
                reservation.setChambre(chambre);
                reservation.setEtudiants(Set.of(etudiant));
                return reservationRepository.save(reservation);
            }
        }

        throw new RuntimeException("Aucune chambre disponible dans le bloc " + bloc.getNomBloc());
    }
    private long getCapacityByType(TypeChambre type) {
        return switch (type) {
            case SIMPLE -> 1;
            case DOUBLE -> 2;
            case TRIPLE -> 3;
        };
    }

    private String generateIdReservation(Chambre chambre, Bloc bloc) {
        int currentYear = LocalDate.now().getYear();
        return chambre.getNumeroChambre() + "-" + bloc.getNomBloc() + "-" + currentYear;
    }
}