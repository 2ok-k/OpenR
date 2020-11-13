package com.miage.openrh.controllers;

import com.miage.openrh.models.Categorie;
import com.miage.openrh.models.DemandeConge;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class DemandeCongeController {
    @PostMapping(value = "/enregistrerDemandeConge")
    public String enregistrerDemandeConge(@ModelAttribute("demandeConge") DemandeConge demandeConge, Model model) {
        try {
            demandeConge.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return demandeConge(model);
    }


    @GetMapping(value ="/demandeConge")
    public String demandeConge(Model model){
        DemandeConge demandeConge = new DemandeConge();

        model.addAttribute("DemandeConge",demandeConge);

        return "demandeConge";
    }
}
