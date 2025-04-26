package com.Deuxieme.projet.service_imp;

import com.Deuxieme.projet.Model.Message;
import com.Deuxieme.projet.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
public class MessageServiceImpl {
    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private MessageRepository repository;
    public String Envoyer(Message m){
        Message message=new Message(m.getId_user_envoi(),m.getId_user_recu(),m.getMessage(),m.getDate());
        if (repository.save(message)==null){
            return "Message non envoyer";
        }else {
            return "Message envoyer";
        }
    }
    public ArrayList<Message> RecupererMessages(int id1, int id2) throws SQLException {
        ArrayList<Message> messages = new ArrayList<Message>();
        String req="select *" +
                " from message " +
                "where (id_user_envoi= ? or id_user_envoi= ?) and (id_user_recu= ? or id_user_recu= ?)" +
                "order by date";
        return (ArrayList<Message>) jdbc.query(
                req,
                new Object[]{id1, id2, id1, id2},
                (rs, rowNum) -> new Message(
                        rs.getInt("id_user_envoi"),
                        rs.getInt("id_user_recu"),
                        rs.getString("message"),
                        rs.getDate("date").toLocalDate()
                )
        );

    }
}
