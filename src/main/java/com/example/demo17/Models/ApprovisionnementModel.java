package com.example.demo17.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "approvisionnement")
public class ApprovisionnementModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int qte;
    private LocalDate dateappro;
    @ManyToOne
    @JoinColumn(name="produit_id", insertable = false, updatable = false)
    private ProduitModel produitModel;
    private int produit_id;
}
