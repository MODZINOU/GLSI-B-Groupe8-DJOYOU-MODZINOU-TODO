package com.example.demo17.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vente")
public class VenteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codevente;
    private LocalDate datevente;
    @ManyToOne()
    @JoinColumn(name = "clientId", insertable = false, updatable = false)
    private ClientModel clientModel;
    private int clientId;

    @ManyToOne
    @JoinColumn(name = "utilisateurId", insertable = false, updatable = false)
    private UtilisateurModel utilisateurModel;
    private int utilisateurId;
}
