package com.example.demo17.Services;

import com.example.demo17.Models.ClientModel;
import com.example.demo17.Repository.ClientRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public ClientModel showOneClient(int id) {
        return clientRepository.findById(id).get();

    }


    public void delete(int id){
        clientRepository.deleteById(id);
    }

    public ClientModel nom (String nom){
        return clientRepository.findByNom(nom);
    }

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path="C:\\SEMESTRE6\\java web\\demo17\\demo17\\Report";
        List<ClientModel> clientModels = clientRepository.findAll();
        File file = ResourceUtils.getFile("C:\\SEMESTRE6\\java web\\demo17\\demo17\\src\\main\\resources\\templates\\client\\client.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(clientModels);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("client", "rapport");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "C:\\SEMESTRE6\\java web\\demo17\\demo17\\src\\main\\resources\\templates\\client"+"client.html");
        }
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path+"client.pdf");
        }
        return "report generated in path :"+path;
    }
}
