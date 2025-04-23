package com.Deuxieme.projet.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "id_user")
public class Admin extends User {
    @OneToMany(mappedBy = "admin")
    private List<ContratCA> contratsCommercants;

    // Getters and Setters
}