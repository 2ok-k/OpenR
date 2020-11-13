package com.miage.openrh.controllers;

import com.miage.openrh.models.Entreprise;
import com.miage.openrh.models.Genre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class EntrepriseController {

    @PostMapping(value = "/enregistrerentreprise")
    public String enregistrerentreprise(@ModelAttribute("entreprise") Entreprise entreprise, Model model) {
        try {
            entreprise.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return entreprise(model);
    }


    @GetMapping(value ="/entreprise")
    public String entreprise(Model model){
        Entreprise entreprise = new Entreprise();

        model.addAttribute("Entreprise",entreprise);

        return "entreprise";
    }
}
