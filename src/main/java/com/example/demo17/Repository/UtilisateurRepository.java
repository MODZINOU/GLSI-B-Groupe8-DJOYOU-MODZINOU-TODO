package com.example.demo17.Repository;

import com.example.demo17.Models.UtilisateurModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurModel, Integer> {
}
