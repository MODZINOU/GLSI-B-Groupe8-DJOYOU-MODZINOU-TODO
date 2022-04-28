package com.example.demo17.Controllers;

import com.example.demo17.Models.LigneVenteModel;
import com.example.demo17.Models.ProduitModel;
import com.example.demo17.Models.VenteModel;
import com.example.demo17.Repository.LigneVenteRepository;
import com.example.demo17.Repository.VenteRepository;
import com.example.demo17.Services.CategorieService;
import com.example.demo17.Services.LigneVenteService;
import com.example.demo17.Services.ProduitService;
import com.example.demo17.Services.VenteService;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.AggregateUtils;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("commande")
public class LigneVenteController {

    @Autowired
    private LigneVenteService ligneVenteService;

    @Autowired
    private VenteService venteService;

    @Autowired
    private ProduitService produitService;

    @Autowired
    private VenteRepository venteRepository;

    @GetMapping("/afficher")
    public String Listecommande(Model model){
        model.addAttribute("commande", ligneVenteService.listelignevente());
        return "commande/afficher";
    }


    @GetMapping("/enregistrer")
    public String renseigner(Model model)
    {
        model.addAttribute("listevente",venteService.listevente());
        model.addAttribute("produit",produitService.ShowProduits());
        model.addAttribute("unevente", ligneVenteService.lu(venteRepository.a()));
        return "commande/enregistrer";
    }

    @PostMapping("/save")
    public String save(LigneVenteModel ligneVenteModel, VenteModel venteModel)
    {
        //int a = ligneVenteService.t();

        ligneVenteModel.setVenteId(venteRepository.a());
        ligneVenteService.save(ligneVenteModel);
        return "redirect:/commande/enregistrer";
    }

    @PostMapping("/edit")
    public String editLigneCommande(@ModelAttribute("commande") LigneVenteModel ligneVenteModel){
        ligneVenteService.save(ligneVenteModel);
        return "redirect:/commande/afficher";
    }


    @GetMapping ("delete/{id}")
    public String deletelignecommade(@PathVariable("id") int id)
    {
        ligneVenteService.delete(id);
        return "redirect:/commande/enregistrer";
    }

    @GetMapping("edit/{id}")
    public String FormEdit(@PathVariable("id") int id , Model model){
        model.addAttribute("unecommade", ligneVenteService.showOneLigneVente(id));
        model.addAttribute("vente", venteService.listevente());
        return "/commande/modifier";
    }

    @GetMapping("facture/{id}")
    public String fact(@PathVariable("id") int id, Model model, LigneVenteRepository ligneVenteRepository, LigneVenteModel ligneVenteModel){
        model.addAttribute("facture", venteService.showOneVente(id));
        model.addAttribute("unevente", ligneVenteService.lu(id));
        //model.addAttribute("fact", ligneVenteService.b(id));

        int total = 0;
        List<LigneVenteModel> lig =  ligneVenteService.lu(id);
        for(int i = 0; i<lig.size(); i++){
            int quantite = lig.get(i).getQuantite();
            int prix = lig.get(i).getProduitModel().getPrix();
            total += quantite * prix;
        }

        model.addAttribute("total", total);
        return "/commande/facture";
    }

    @PostMapping("/facturer")
    public String facto(@ModelAttribute("facture") VenteModel venteModel){
        return "redirect:/commande/facture";
    }


}
