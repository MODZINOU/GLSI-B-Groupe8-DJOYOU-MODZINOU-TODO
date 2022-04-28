package com.example.demo17.Services;

import com.example.demo17.Models.LigneVenteModel;
import com.example.demo17.Models.VenteModel;
import com.example.demo17.Repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {

    @Autowired
    private VenteRepository venteRepository;

    public List<VenteModel> listevente(){
        return venteRepository.findAll();
    }

    public void save(VenteModel venteModel){
        venteRepository.save(venteModel);
    }

    public VenteModel showOneVente(int id){
        return venteRepository.findById(id).get();
    }

    public void delete(int id){
        venteRepository.deleteById(id);
    }

    public List<LigneVenteModel> lu(int id){
        return venteRepository.lu(id);
    }

}
