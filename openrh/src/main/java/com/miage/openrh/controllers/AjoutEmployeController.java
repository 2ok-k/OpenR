package com.miage.openrh.controllers;

import com.miage.openrh.models.AjoutEmploye;
import com.miage.openrh.models.Categorie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class AjoutEmployeController {

    @PostMapping(value = "/enregistreremploye")
    public String enregistreremploye(@ModelAttribute("ajoutEmploye") AjoutEmploye ajoutEmploye, Model model) {
        try {
            ajoutEmploye.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return ajoutEmploye(model);
    }


    @GetMapping(value ="/ajoutEmploye")
    public String ajoutEmploye(Model model){
        AjoutEmploye ajoutEmploye = new AjoutEmploye();

        model.addAttribute("AjoutEmploye",ajoutEmploye);

        return "ajoutEmploye";
    }
}
