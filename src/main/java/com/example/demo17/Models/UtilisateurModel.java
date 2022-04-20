package com.example.demo17.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "utilisateur")
public class UtilisateurModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String Password;
    private String email;
    private String adresse;
    private String telephone;
    @ManyToOne()
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private RoleModel roleModel;
    private int roleId;
}
