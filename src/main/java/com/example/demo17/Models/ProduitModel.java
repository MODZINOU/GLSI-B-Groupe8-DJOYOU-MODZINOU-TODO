package com.example.demo17.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produits")
public class ProduitModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String libelle;
    private int qtstock;
    private int qtseuil;
    private int prix;
    private LocalDate datecreation;
    @ManyToOne()
    @JoinColumn(name = "categorieId", insertable = false, updatable = false)
    private CategorieModel categorieModel;
    private int categorieId;
}
