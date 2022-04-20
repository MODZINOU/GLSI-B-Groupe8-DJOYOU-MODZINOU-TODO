package com.example.demo17.Controllers;

import com.example.demo17.Models.RoleModel;
import com.example.demo17.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/afficher")
    public String aff(Model model){
        model.addAttribute("listerole", roleService.listerole());
        return "/role/afficherole";
    }

    @GetMapping("/enregistrer")
    public String save(RoleModel roleModel){
        return "/role/enregistrer";
    }

    @PostMapping("/save")
    public String enr(RoleModel roleModel){
        roleService.save(roleModel);
        return "redirect:/role/afficher";
    }

    @GetMapping("/modifier/{id}")
    public String mod(@PathVariable("id") int id, Model model){
        model.addAttribute("unrole", roleService.showOneRole(id));
        return "/role/modifier";
    }

    @PostMapping("/update")
    public String update(RoleModel roleModel){
        roleService.save(roleModel);
        return "redirect:/role/afficher";
    }

    @GetMapping("/delete/{id}")
    public String del(@PathVariable("id") int id, RoleModel roleModel){
        roleService.delete(id);
        return "redirect:/role/afficher";
    }
}
