package com.Deuxieme.projet.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "id_user")
public class Client extends User {
    private String adresse;
    private String codePostale;
    private String zip;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

    @OneToMany(mappedBy = "client")
    private List<AvisProduit> avisProduits;

    // Getters and Setters
}