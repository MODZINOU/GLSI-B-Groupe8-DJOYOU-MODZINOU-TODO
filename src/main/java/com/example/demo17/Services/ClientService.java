package com.example.demo17.Services;

import com.example.demo17.Models.ClientModel;
import com.example.demo17.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List <ClientModel> listeclient(){
        return clientRepository.findAll();
    }

    public void saveClient(ClientModel clientModel){
        clientRepository.save(clientModel);
    }

    public ClientModel showOneClient(int id){
        return clientRepository.findById(id).get();
    }

    public void delete(int id){
        clientRepository.deleteById(id);
    }
}
