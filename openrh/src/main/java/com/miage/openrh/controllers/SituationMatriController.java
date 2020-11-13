package com.miage.openrh.controllers;

import com.miage.openrh.models.SituationMatri;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class SituationMatriController {
    @PostMapping(value = "/enregistrersituationM")
    public String enregistrersituationM(@ModelAttribute("situationMatri") SituationMatri situationMatri, Model model) {
        try {
            situationMatri.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return situationMatri(model);
    }


    @GetMapping(value ="/situationMatri")
    public String situationMatri(Model model){
        SituationMatri situationMatri = new SituationMatri();

        model.addAttribute("SituationMatri",situationMatri);

        return "situationMatri";
    }
}
