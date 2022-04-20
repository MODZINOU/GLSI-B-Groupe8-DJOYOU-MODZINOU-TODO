package com.example.demo17.Services;

import com.example.demo17.Models.RoleModel;
import com.example.demo17.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<RoleModel> listerole(){
        return roleRepository.findAll();
    }

    public void save(RoleModel roleModel){
        roleRepository.save(roleModel);
    }

    public RoleModel showOneRole(int id){
        return roleRepository.findById(id).get();
    }

    public void delete(int id){
        roleRepository.deleteById(id);
    }
}
