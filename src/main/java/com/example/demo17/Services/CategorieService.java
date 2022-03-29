package com.example.demo17.Services;

import com.example.demo17.Models.CategorieModel;
import com.example.demo17.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public void saveCategorie(CategorieModel categorieModel){
        categorieRepository.save(categorieModel);
    }

    public List<CategorieModel> showCategorie(){
        return categorieRepository.findAll();
    }

    public CategorieModel showOneCategorie(int id){
        return categorieRepository.findById(id).get();
    }

    public void deleteCategorie(int id){
        categorieRepository.deleteById(id);
    }
}
