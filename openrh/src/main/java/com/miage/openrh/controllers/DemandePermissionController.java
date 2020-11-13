package com.miage.openrh.controllers;

import com.miage.openrh.models.Categorie;
import com.miage.openrh.models.DemandePermission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class DemandePermissionController {

    @PostMapping(value = "/enregistrerDemandePerm")
    public String enregistrerDemandePerm(@ModelAttribute("demandePermission") DemandePermission demandePermission, Model model) {
        try {
            demandePermission.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return demandePermission(model);
    }


    @GetMapping(value ="/demandePermission")
    public String demandePermission(Model model){
        DemandePermission demandePermission = new DemandePermission();

        model.addAttribute("DemandePermission",demandePermission);

        return "demandePermission";
    }
}
