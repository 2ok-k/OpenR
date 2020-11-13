package com.miage.openrh.controllers;

import com.miage.openrh.models.Genre;
import com.miage.openrh.models.Pays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
@Controller
public class PaysController {

    @PostMapping(value = "/enregistrerpays")
    public String enregistrerpays(@ModelAttribute("pays") Pays pays, Model model) {
        try {
            pays.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return pays(model);
    }


    @GetMapping(value ="/pays")
    public String pays(Model model){
        Pays pays = new Pays();

        model.addAttribute("Pays",pays);

        return "pays";
    }
}
