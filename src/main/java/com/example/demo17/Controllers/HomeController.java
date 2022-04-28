package com.example.demo17.Controllers;

import com.example.demo17.Models.UtilisateurModel;
import com.example.demo17.Security.UserPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/")
    public String hello(){
        return "exemple";
    }

    @RequestMapping("/login")
    public String connetion(){
        return "/connect/login";
    }

    @RequestMapping("/logout")
    public String deconnexio(){
        return "logout";
    }

    /*@GetMapping("/ok")
    public String user(UtilisateurModel utilisateurModel, Model model){
        model.addAttribute("user", utilisateurModel.getNom());
        return "exemple";
    }*/
}
