package com.miage.openrh.controllers;

import com.miage.openrh.models.Categorie;
import com.miage.openrh.models.Entreprise;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class CategorieController {
    @PostMapping(value = "/enregistrercategorie")
    public String enregistrercategorie(@ModelAttribute("categorie") Categorie categorie, Model model) {
        try {
            categorie.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return categorie(model);
    }


    @GetMapping(value ="/categorie")
    public String categorie(Model model){
        Categorie categorie = new Categorie();

        model.addAttribute("Categorie",categorie);

        return "categorie";
    }
}
