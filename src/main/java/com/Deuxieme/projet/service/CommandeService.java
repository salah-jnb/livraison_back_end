package com.Deuxieme.projet.service;

import com.Deuxieme.projet.Model.Commande;
import com.Deuxieme.projet.Model.StatutCommande;

import java.util.List;
import java.util.Optional;

public interface CommandeService {
    List<Commande> listAllCommandes(); // Liste toutes les commandes
    Optional<Commande> getCommandeById(int idCmd); // Récupère une commande par ID
    Commande updateStatutCommande(int idCmd, StatutCommande nouveauStatut); // Met à jour le statut d'une commande
    Commande marquerCommandePayee(int idCmd);
}