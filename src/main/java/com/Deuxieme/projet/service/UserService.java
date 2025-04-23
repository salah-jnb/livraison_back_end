package com.Deuxieme.projet.service;

import com.Deuxieme.projet.Model.AvisLivreur;
import com.Deuxieme.projet.Model.Livreur;
import com.Deuxieme.projet.Model.User;
import java.util.List;

public interface UserService {
    byte[] getImageById(Integer idUser);
    User getUserById(Integer idUser);
    User updateUserInfo(Integer idUser, String nom, String prenom, Integer age, String tlf, String email);
    List<AvisLivreur> getAllAvisForLivreur(Integer id_l);
    Livreur updateTarifRetour(Integer id_l, double tarif_retour);
    Livreur updateTarifLivraison(Integer id_l, double tarif_livraison);
    AvisLivreur addAvisToLivreur(Integer id_l, Integer idUser, String message);
}