package com.miage.openrh.controllers;

import com.miage.openrh.models.PremiereInscrip;
import com.miage.openrh.models.SituationMatri;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class PremiereInscripController {
    @PostMapping(value = "/enregistrerpremiereinscript")
    public String enregistrerpremiereinscript(@ModelAttribute("premiereInscription") PremiereInscrip premiereInscription, Model model) {
        try {
            premiereInscription.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return premiereInscription(model);
    }


    @GetMapping(value ="/premiereInscription")
    public String premiereInscription(Model model){
        PremiereInscrip premiereInscription = new PremiereInscrip();

        model.addAttribute("PremiereInscrip",premiereInscription);

        return "premiereInscription";
    }
}
