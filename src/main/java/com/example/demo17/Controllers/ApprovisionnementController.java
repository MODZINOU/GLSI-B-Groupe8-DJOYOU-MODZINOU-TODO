package com.example.demo17.Controllers;

import com.example.demo17.Models.ApprovisionnementModel;
import com.example.demo17.Models.ProduitModel;
import com.example.demo17.Services.ApprovisionnementService;
import com.example.demo17.Services.ProduitService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.time.LocalDate;

@Controller
@RequestMapping("approvisionnement")
public class ApprovisionnementController {

    @Autowired
    private ApprovisionnementService approvisionnementService;

    @Autowired
    private ProduitService produitService;

    @GetMapping("afficher")
    public String aff(Model model){
        model.addAttribute("liste", approvisionnementService.list());
        return "approvisionnement/afficher";
    }

    @GetMapping("enregistrer/{id}")
    public String enr(@PathVariable("id") int id, Model model){
        model.addAttribute("produit", produitService.ShowOneProduit(id));
        return "approvisionnement/enregistrer";
    }

    @PostMapping("save")
    public String save(ApprovisionnementModel approvisionnementModel){
        approvisionnementModel.setDate(LocalDate.now());
        approvisionnementService.save(approvisionnementModel);
        int prodkey = approvisionnementModel.getProduitId();
        ProduitModel produitModel = produitService.ShowOneProduit(prodkey);
        produitModel.setQtstock(produitModel.getQtstock() + approvisionnementModel.getQte());
        produitService.saveProduit(produitModel);

        return "redirect:/approvisionnement/afficher";
    }
}
