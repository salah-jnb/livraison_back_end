package com.Deuxieme.projet.repository;

import com.Deuxieme.projet.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
    Optional<Commande> findByIdCmd(Integer idCmd);
    void deleteByIdCmd(Integer idCmd);
}