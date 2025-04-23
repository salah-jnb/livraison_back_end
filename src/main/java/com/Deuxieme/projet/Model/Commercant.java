package com.Deuxieme.projet.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "commercant")
@PrimaryKeyJoinColumn(name = "id_user")
public class Commercant extends User {
    @OneToMany(mappedBy = "commercant")
    private List<Produit> produits;

    @OneToMany(mappedBy = "commercant")
    private List<ContratCL> contratsLivreurs;

    @OneToMany(mappedBy = "commercant")
    private List<ContratCA> contratsAdmins;

    @OneToMany(mappedBy = "commercant")
    private List<AvisLivreur> avisLivreurs;

    // Getters and Setters
}