package com.Deuxieme.projet.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
public class Message {
    @Id
    private int id;
    private int id_user_envoi,id_user_recu;
    private String message;
    private LocalDate date;

    public Message(int id_envoy, int id_recu, String message, LocalDate d){
        this.id_user_envoi=id_envoy;
        this.id_user_recu=id_recu;
        this.message=message;
        this.date=d;
    }
    public Message(){}
    // Getters et Setters sont appeleé par les anotations @Getter et @Setter
}