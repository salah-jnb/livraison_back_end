package com.Deuxieme.projet.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "dashboardL")
public class DashboardL {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_l")
    private Livreur livreur;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_cmd")
    private Commande commande;

    // Getters and Setters
}