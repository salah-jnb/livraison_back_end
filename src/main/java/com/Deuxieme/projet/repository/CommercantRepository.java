package com.Deuxieme.projet.repository;

import com.Deuxieme.projet.Model.Commercant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommercantRepository extends JpaRepository<Commercant, Integer> {

}