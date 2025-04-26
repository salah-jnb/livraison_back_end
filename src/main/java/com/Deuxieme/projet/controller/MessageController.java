package com.Deuxieme.projet.controller;


import com.Deuxieme.projet.Model.Message;
import com.Deuxieme.projet.service_imp.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    MessageServiceImpl ms;

    @PostMapping("/envoyermessage")
    public String envoyerMessage(int id_envoy, int id_recu, String message, LocalDate d){
        Message m=new Message(id_envoy,id_recu,message,d);
        return ms.Envoyer(m);
    }
    @GetMapping("/recuperationmessage")
    public ArrayList<Message> recuperation(@RequestParam Integer id1, @RequestParam Integer id2) throws SQLException {
        return ms.RecupererMessages(id1,id2);
    }
}