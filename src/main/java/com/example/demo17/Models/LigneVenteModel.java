package com.example.demo17.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lignevente")
public class LigneVenteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantite;
    @ManyToOne()
    @JoinColumn(name = "venteId", insertable = false, updatable = false)
    private VenteModel venteModel;
    private int venteId;

    @ManyToOne()
    @JoinColumn(name = "produitId", insertable = false, updatable = false)
    private ProduitModel produitModel;
    private int produitId;


}
