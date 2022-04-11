package com.example.demo17.Controllers;

import com.example.demo17.Models.CategorieModel;
import com.example.demo17.Services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("categorie")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/afficher")
    public String aff(Model model){
        model.addAttribute("ListeCategories", categorieService.showCategorie());
        return "/categories/showCategorie";
    }

    @GetMapping("/enregistrer")
    public String sauvegarde(){
        return "/categories/enregistrer";
    }

    @PostMapping("/save")
    public String save(CategorieModel categorieModel){
        categorieService.saveCategorie(categorieModel);
        return "redirect:/categorie/afficher";
    }

    @GetMapping("/modifier/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("uneCategorie", categorieService.showOneCategorie(id));
        return "categories/modifier";
    }

    @PostMapping("/update")
    public String modif(@ModelAttribute("Categorie") CategorieModel categorieModel){
        categorieService.saveCategorie(categorieModel);
        return "redirect:/categorie/afficher";
    }

    @GetMapping("supprimer/{id}")
    public String delete(@PathVariable("id") int id){
        categorieService.deleteCategorie(id);
        return "redirect:/categorie/afficher";
    }

    @GetMapping("/navigation")
    public String nav(){
        return "/categories/initial";
    }

}
