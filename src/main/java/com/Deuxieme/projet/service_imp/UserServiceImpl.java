package com.Deuxieme.projet.service_imp;

import com.Deuxieme.projet.Model.*;
import com.Deuxieme.projet.repository.*;
import com.Deuxieme.projet.service.UserService;
import com.Deuxieme.projet.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LivreurRepository livreurRepository;
    private final CommercantRepository commercantRepository;
    private final AvisLivreurRepository avisLivreurRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           LivreurRepository livreurRepository,
                           CommercantRepository commercantRepository,
                           AvisLivreurRepository avisLivreurRepository) {
        this.userRepository = userRepository;
        this.livreurRepository = livreurRepository;
        this.commercantRepository = commercantRepository;
        this.avisLivreurRepository = avisLivreurRepository;
    }

    @Override
    public byte[] getImageById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));
        return user.getPhotodeprofil().getBytes();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));
    }

    @Override
    public User updateUserInfo(Integer id, String nom, String prenom, Integer age, String tlf, String email) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));

        if (nom != null) user.setNom(nom);
        if (prenom != null) user.setPrenom(prenom);
        if (age != null) user.setAge(age);
        if (tlf != null) user.setTlf(tlf);
        if (email != null) user.setEmail(email);

        return userRepository.save(user);
    }

    @Override
    public List<AvisLivreur> getAllAvisForLivreur(Integer livreurId) {
        if (!livreurRepository.existsById(livreurId)) {
            throw new EntityNotFoundException("Livreur non trouvé");
        }
        return avisLivreurRepository.findByLivreur_IdLivreur(livreurId);
    }

    @Override
    public Livreur updateTarifRetour(Integer livreurId, double nouveauTarif) {
        Livreur livreur = livreurRepository.findById(livreurId)
                .orElseThrow(() -> new EntityNotFoundException("Livreur non trouvé"));

        livreur.setTarifRetour(nouveauTarif);
        return livreurRepository.save(livreur);
    }

    @Override
    public Livreur updateTarifLivraison(Integer livreurId, double nouveauTarif) {
        Livreur livreur = livreurRepository.findById(livreurId)
                .orElseThrow(() -> new EntityNotFoundException("Livreur non trouvé"));

        livreur.setTarifLivraison(nouveauTarif);
        return livreurRepository.save(livreur);
    }

    @Override
    public AvisLivreur addAvisToLivreur(Integer commercantId, Integer livreurId, String message) {
        Commercant commercant = commercantRepository.findById(commercantId)
                .orElseThrow(() -> new EntityNotFoundException("Commerçant non trouvé"));

        Livreur livreur = livreurRepository.findById(livreurId)
                .orElseThrow(() -> new EntityNotFoundException("Livreur non trouvé"));

        AvisLivreur avis = new AvisLivreur();
        avis.setCommercant(commercant);
        avis.setLivreur(livreur);
        avis.setMessage(message);
        avis.setDate(LocalDateTime.now());

        return avisLivreurRepository.save(avis);
    }


}