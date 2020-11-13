package com.miage.openrh.controllers;

import com.miage.openrh.models.Secteur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
@Controller
public class SecteurController {
    @PostMapping(value = "/enregistrersecteur")
    public String enregistrersecteur(@ModelAttribute("secteur") Secteur secteur, Model model) {
        try {
            secteur.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return secteur(model);
    }


    @GetMapping(value ="/secteur")
    public String secteur(Model model){
        Secteur secteur = new Secteur();

        model.addAttribute("Secteur",secteur);

        return "secteur";
    }
}
