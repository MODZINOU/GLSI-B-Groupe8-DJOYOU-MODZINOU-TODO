package com.example.demo17.Repository;

import com.example.demo17.Models.CategorieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository <CategorieModel, Integer > {
}
