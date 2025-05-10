package com.Deuxieme.projet.repository;

import com.Deuxieme.projet.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Integer> {
}
