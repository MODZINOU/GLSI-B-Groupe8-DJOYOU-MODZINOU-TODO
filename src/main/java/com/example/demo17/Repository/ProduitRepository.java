package com.example.demo17.Repository;

import com.example.demo17.Models.ProduitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<ProduitModel, Integer> {
}
