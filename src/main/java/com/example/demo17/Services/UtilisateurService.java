package com.example.demo17.Services;

import com.example.demo17.Models.UtilisateurModel;
import com.example.demo17.Repository.RoleRepository;
import com.example.demo17.Repository.UtilisateurRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<UtilisateurModel> listutilisateur(){
        return utilisateurRepository.findAll();
    }

    public void save(UtilisateurModel utilisateurModel){
        utilisateurRepository.save(utilisateurModel);
    }

    public UtilisateurModel showOneUtilisateur(int id){
        return utilisateurRepository.findById(id).get();
    }

    public void delete(int id){

        utilisateurRepository.deleteById(id);
    }

    /*public UserDetails user(String nom) throws UsernameNotFoundException{
        UtilisateurModel utilisateurModel = utilisateurRepository.findBynom(nom);
        if(utilisateurModel == null){
            System.out.println("utilisateur introuvable");
            throw new UsernameNotFoundException("utilisateur introuvable");
        }
        else {
            System.out.println("utilisateur trouver: {}" +nom);
        }
    }*/
}
