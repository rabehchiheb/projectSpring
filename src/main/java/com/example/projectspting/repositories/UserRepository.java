package com.example.projectspting.repositories;

import com.example.projectspting.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository <Utilisateur,Integer> {
     Set<Utilisateur> findUtilisateurByNom(String nom);
     Utilisateur findUtilisateurByNomAndEmail(String nom , String email);
}
