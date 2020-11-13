package com.miage.openrh.controllers;

import com.miage.openrh.models.Structure;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class StructureController {
    @PostMapping(value = "/enregistrerstructure")
    public String enregistrerstructure(@ModelAttribute("structure") Structure structure, Model model) {
        try {
            structure.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return structure(model);
    }


    @GetMapping(value ="/structure")
    public String structure(Model model){
        Structure structure = new Structure();

        model.addAttribute("Structure",structure);

        return "structure";
    }
}
