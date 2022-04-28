package com.example.demo17.Controllers;

import com.example.demo17.Models.UtilisateurModel;
import com.example.demo17.Services.RoleService;
import com.example.demo17.Services.UtilisateurService;
import jdk.jfr.Category;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("utilisateur")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/afficher")
    public String afficher(Model model){
        model.addAttribute("listeutilisateur", utilisateurService.listutilisateur());
        return "/utilisateur/afficher";
    }

    @GetMapping("/enregistrer")
    public String save(Model model){
        model.addAttribute("listerole", roleService.listerole());
        return "/utilisateur/enregistrer";
    }

    @PostMapping("/save")
    public String save(UtilisateurModel utilisateurModel){
        utilisateurService.save(utilisateurModel);
        return "redirect:/utilisateur/afficher";
    }

    @GetMapping("/modifier/{id}")
    public String modif(@PathVariable("id") int id, Model model){
        model.addAttribute("unutilisateur", utilisateurService.showOneUtilisateur(id));
        model.addAttribute("role", roleService.listerole());
        return "utilisateur/modifier";
    }

    @PostMapping("/update")
    public String update(UtilisateurModel utilisateurModel){
        utilisateurService.save(utilisateurModel);
        return "redirect:/utilisateur/afficher";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, UtilisateurModel utilisateurModel){
        utilisateurService.delete(id);
        return "redirect:/utilisateur/afficher";
    }


    @Data
    class RoletoUser{
        private String nom;
        private String role;
    }
}
