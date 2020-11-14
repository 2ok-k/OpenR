package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.Secteur;
import com.miage.openrh.models.TypeContrat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        List<Secteur> secteurs=new ArrayList<>();
        Database db =new Database("root", "","openrh");
        db.connect();

        try {
            db.sendQuery("SELECT * FROM secteur",resultSet -> {
                while(resultSet.next()){
                    secteurs.add(new Secteur(resultSet.getInt("id_sect"),resultSet.getString("lib_sect")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        model.addAttribute("secteurs",secteurs);

        model.addAttribute("Secteur",secteur);

        return "secteur";
    }
}
