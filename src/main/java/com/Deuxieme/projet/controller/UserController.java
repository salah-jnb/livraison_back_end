package com.Deuxieme.projet.controller;

import com.Deuxieme.projet.Model.*;
import com.Deuxieme.projet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserInfo(
            @PathVariable Integer id,
            @RequestBody User userDetails) {
        User updatedUser = userService.updateUserInfo(
                id,
                userDetails.getNom(),
                userDetails.getPrenom(),
                userDetails.getAge(),
                userDetails.getTlf(),
                userDetails.getEmail());
        return ResponseEntity.ok(updatedUser);
    }



    @RestController
    @RequestMapping("/api/livreurs")
    public static class LivreurController {

        private final UserService userService;

        @Autowired
        public LivreurController(UserService userService) {
            this.userService = userService;
        }

        @PutMapping("/{id}/tarif-livraison")
        public ResponseEntity<Livreur> updateTarifLivraison(
                @PathVariable Integer id,
                @RequestParam double tarif) {
            Livreur livreur = userService.updateTarifLivraison(id, tarif);
            return ResponseEntity.ok(livreur);
        }

        @PutMapping("/{id}/tarif-retour")
        public ResponseEntity<Livreur> updateTarifRetour(
                @PathVariable Integer id,
                @RequestParam double tarif) {
            Livreur livreur = userService.updateTarifRetour(id, tarif);
            return ResponseEntity.ok(livreur);
        }

        @GetMapping("/{id}/avis")
        public ResponseEntity<List<AvisLivreur>> getAvisByLivreurId(
                @PathVariable Integer id) {
            List<AvisLivreur> avis = userService.getAllAvisForLivreur(id);
            return ResponseEntity.ok(avis);
        }

        @PostMapping("/{livreurId}/avis")
        public ResponseEntity<AvisLivreur> addAvisToLivreur(
                @RequestParam Integer commercantId,
                @PathVariable Integer livreurId,
                @RequestParam String message) {
            AvisLivreur avis = userService.addAvisToLivreur(commercantId, livreurId, message);
            return new ResponseEntity<>(avis, HttpStatus.CREATED);
        }
    }


}