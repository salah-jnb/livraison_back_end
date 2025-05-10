package com.Deuxieme.projet.repository;

import com.Deuxieme.projet.Model.AvisLivreur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AvisLivreurRepository extends JpaRepository<AvisLivreur, Long> {
    List<AvisLivreur> findByLivreur_IdLivreur(Integer idLivreur);
}