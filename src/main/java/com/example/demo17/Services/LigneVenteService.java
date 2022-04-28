package com.example.demo17.Services;

import com.example.demo17.Models.LigneVenteModel;
import com.example.demo17.Models.VenteModel;
import com.example.demo17.Repository.LigneVenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Convert;
import java.util.List;

@Service
public class LigneVenteService {
    @Autowired
    private LigneVenteRepository ligneVenteRepository;

    public List<LigneVenteModel> listelignevente(){
        return ligneVenteRepository.findAll();
    }

    public void save(LigneVenteModel ligneVenteModel){

        ligneVenteRepository.save(ligneVenteModel);
    }

    public LigneVenteModel showOneLigneVente(int id){
        return ligneVenteRepository.findById(id).get();
    }

    public void delete(int id){
        ligneVenteRepository.deleteById(id);
    }

    public LigneVenteModel showVenteId(int venteId){
        return ligneVenteRepository.findAllByventeId(venteId);
    }



    public List<LigneVenteModel> ligne(int id){
        return ligneVenteRepository.findAll();
    }

    public List<LigneVenteModel> lu(int id){
        return ligneVenteRepository.lu(id);
    }

   /* public List<LigneVenteModel> b(int id){
        return ligneVenteRepository.b(id);
    }*/


}
