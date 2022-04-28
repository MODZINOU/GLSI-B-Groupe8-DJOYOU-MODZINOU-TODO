package com.example.demo17.Controllers;

import com.example.demo17.Models.LigneVenteModel;
import com.example.demo17.Models.VenteModel;
import com.example.demo17.Repository.LigneVenteRepository;
import com.example.demo17.Security.UserPrincipal;
import com.example.demo17.Services.ClientService;
import com.example.demo17.Services.LigneVenteService;
import com.example.demo17.Services.UtilisateurService;
import com.example.demo17.Services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("vente")
public class VenteController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private VenteService venteService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/afficher")
    public String Listevente(Model model){
        model.addAttribute("vente", venteService.listevente());
        return "vente/afficher";
    }


    @GetMapping("/enregistrer")
    public String renseigner(Model model)
    {
        model.addAttribute("utilisateur",utilisateurService.listutilisateur());
        model.addAttribute("client", clientService.listeclient());

        return "vente/enregistrer";
    }

    @PostMapping("/save")
    public String save(VenteModel venteModel, UserPrincipal userPrincipal)
    {
        venteModel.setDatevente(LocalDate.now());
        venteModel.setUtilisateurId(3);
        venteService.save(venteModel);
        return "redirect:/commande/enregistrer";
    }

    @PostMapping("/edit")
    public String editLigneCommande(@ModelAttribute("vente") VenteModel venteModel){
        venteService.save(venteModel);
        return "redirect:/vente/afficher";
    }


    @GetMapping ("delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        venteService.delete(id);
        return "redirect:/vente/afficher";
    }

    @GetMapping("edit/{id}")
    public String FormEdit(@PathVariable("id") int id , Model model){
        model.addAttribute("unevente", venteService.showOneVente(id));
        model.addAttribute("client", clientService.listeclient());
        model.addAttribute("utilisateur", utilisateurService.listutilisateur());
        return "/commande/modifier";
    }

    @GetMapping("detail/{id}")
    public String vent(@PathVariable("id") int id, LigneVenteService ligneVenteService, Model model){
        model.addAttribute("v", venteService.lu(id));
        return "vente/detail";
    }

    @PostMapping("detail")
    public String v(){
        return "redirect:/commande/detail";
    }


}
