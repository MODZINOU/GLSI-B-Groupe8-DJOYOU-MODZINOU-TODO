package com.example.demo17.Services;

import com.example.demo17.Models.ApprovisionnementModel;
import com.example.demo17.Repository.ApprovisionnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovisionnementService {

    @Autowired
    private ApprovisionnementRepository approvisionnementRepository;

    public void saveApprovisionnement(ApprovisionnementModel approvisionnementModel){
        approvisionnementRepository.save(approvisionnementModel);
    }

    public List<ApprovisionnementModel> showApprovisionnement(){
        return approvisionnementRepository.findAll();
    }

    public ApprovisionnementModel showOneApprovisionnement(int id){
        return approvisionnementRepository.findById(id).get();
    }

    public void deleteApprovisionnement(int id){
        approvisionnementRepository.deleteById(id);
    }
}
