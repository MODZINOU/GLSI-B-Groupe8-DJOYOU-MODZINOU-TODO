package com.example.demo17.Controllers;

import com.example.demo17.Models.ProduitModel;
import com.example.demo17.Services.CategorieService;
import com.example.demo17.Services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/afficher")
    public String displayProduit(Model model){
        model.addAttribute("produits", produitService.ShowProduits());
        return "produits/showProduit";
    }


    @GetMapping("/form")
    public String renseigner(Model model)
    {
        model.addAttribute("ListeCategories",categorieService.showCategorie());
        return "produits/saveProduit";
    }

    @PostMapping("/save")
    public String saveProduit(ProduitModel produitModel)
    {

        produitModel.setDatecreation(LocalDate.now());
        produitModel.setQtstock(0);
        produitService.saveProduit(produitModel);
        return "redirect:/produits/afficher";
    }

    @PostMapping("/edit")
    public String editProduit(@ModelAttribute("produit") ProduitModel produitModel){
        produitService.saveProduit((produitModel));
        return "redirect:/produits/afficher";
    }


    @GetMapping ("delete/{id}")
    public String deleteProduit(@PathVariable("id") int id)
    {
        produitService.DeleteProduit(id);
        return "redirect:/produits/afficher";
    }

    @GetMapping("edit/{id}")
    public String FormEdit(@PathVariable("id") int id , Model model){
        model.addAttribute("UnProduit", produitService.ShowOneProduit(id));
        model.addAttribute("UneCategorie", categorieService.showCategorie());
        return "/produits/formEdit";
    }




}
