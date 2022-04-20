package com.example.demo17.Controllers;

import com.example.demo17.Models.ApprovisionnementModel;
import com.example.demo17.Services.ApprovisionnementService;
import com.example.demo17.Services.CategorieService;
import com.example.demo17.Services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("approvisionnement")
public class ApprovisionnementController {
    @Autowired
    private ApprovisionnementService approvisionnementService;

    @Autowired
    private ProduitService produitService;

    @Autowired
    private CategorieService categorieService;

    @GetMapping("afficher")
    public String afficher(Model model){
        model.addAttribute("ListeApprovisionnemet", approvisionnementService.showApprovisionnement());
        return "approvisionnement/afficher";
    }

    @PostMapping("/save")
    public String save(ApprovisionnementModel approvisionnementModel){
        approvisionnementModel.setDateappro(LocalDate.now());
        approvisionnementService.saveApprovisionnement(approvisionnementModel);
        return "redirect:/approvisionnement/afficher";
    }

    @GetMapping("/enregistrer/{id}")
    public String saveapprovisionnement(@PathVariable("id") int id, Model model){
        model.addAttribute("UnProduit", produitService.ShowOneProduit(id));
        System.out.println("id = "+produitService.ShowOneProduit(id));
        return "approvisionnement/enregistrer";
    }



}
