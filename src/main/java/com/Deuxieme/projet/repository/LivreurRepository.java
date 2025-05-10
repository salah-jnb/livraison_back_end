package com.Deuxieme.projet.repository;

import com.Deuxieme.projet.Model.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreurRepository extends JpaRepository<Livreur, Integer> {
}