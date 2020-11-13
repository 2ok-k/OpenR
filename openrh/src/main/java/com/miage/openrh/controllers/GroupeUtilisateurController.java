package com.miage.openrh.controllers;

import com.miage.openrh.models.GroupeUtilisateur;
import com.miage.openrh.models.SituationMatri;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class GroupeUtilisateurController {
    @PostMapping(value = "/enregistrergrpeUsers")
    public String enregistrergrpeUsers(@ModelAttribute("groupeUtilisateur") GroupeUtilisateur groupeUtilisateur, Model model) {
        try {
            groupeUtilisateur.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return groupeUtilisateur(model);
    }


    @GetMapping(value ="/groupeUtilisateur")
    public String groupeUtilisateur(Model model){
        GroupeUtilisateur groupeUtilisateur = new GroupeUtilisateur();

        model.addAttribute("GroupeUtilisateur",groupeUtilisateur);

        return "groupeUtilisateur";
    }
}
