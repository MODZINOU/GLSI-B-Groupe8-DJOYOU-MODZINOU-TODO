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

    public List<ApprovisionnementModel> list(){
        return approvisionnementRepository.findAll();
    }

    public void save(ApprovisionnementModel approvisionnementModel){
        approvisionnementRepository.save(approvisionnementModel);
    }

    public ApprovisionnementModel unapp(int id){
        return approvisionnementRepository.findById(id).get();
    }

    public void delete(int id){
        approvisionnementRepository.deleteById(id);
    }
}
