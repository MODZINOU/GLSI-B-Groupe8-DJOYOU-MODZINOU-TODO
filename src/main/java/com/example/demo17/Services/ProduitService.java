package com.example.demo17.Services;

import com.example.demo17.Models.ProduitModel;
import com.example.demo17.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    //enregistrement
    public void saveProduit(ProduitModel produit){
        produitRepository.save(produit);
    }

    //liste de produit
    public List<ProduitModel> ShowProduits(){
        return produitRepository.findAll();
    }

    //recherche
    public ProduitModel ShowOneProduit(int id){
        Optional<ProduitModel> optional = produitRepository.findById(id);
        ProduitModel produitModel = null;
        if(optional.isPresent()){
            produitModel = optional.get();
        }
        else
            throw new RuntimeException("id intouvable");
        return produitModel;
    }

    //suprimer un produit
    public void DeleteProduit(int id){
        produitRepository.deleteById(id);
    }


}
