package com.example.demo17.Controllers;

import com.example.demo17.Models.ClientModel;
import com.example.demo17.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/afficher")
    public String afficher(Model model){
        model.addAttribute("client", clientService.listeclient());
        return "/client/afficheclient";
    }

    @GetMapping("/enregistrer")
    public String save(ClientModel clientModel){
        return "/client/save";
    }

    @PostMapping("/save")
    public String enr(ClientModel clientModel){
        clientService.saveClient(clientModel);
        return "redirect:/clients/afficher";
    }

    @GetMapping("/modifier/{id}")
    public String modif(@PathVariable("id") int id, Model model){
        model.addAttribute("unclient", clientService.showOneClient(id));
        return "/client/modifier";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("client") ClientModel clientModel){
        clientService.saveClient(clientModel);
        return "redirect:/clients/afficher";
    }

    @GetMapping("delete/{id}")
    public String del(@PathVariable("id") int id){
        clientService.delete(id);
        return "redirect:/clients/afficher";
    }
}
