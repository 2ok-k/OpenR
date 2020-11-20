package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.AjoutEmploye;
import com.miage.openrh.models.Categorie;
import com.miage.openrh.models.DemandeConge;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DemandeCongeController {
    @PostMapping(value = "/enregistrerDemandeConge")
    public String enregistrerDemandeConge(@ModelAttribute("demandeConge") DemandeConge demandeConge, Model model) {
        try {
            demandeConge.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return demandeConge(model);
    }


    @GetMapping(value ="/demandeConge")
    public String demandeConge(Model model){
        DemandeConge demandeConge = new DemandeConge();
        List<DemandeConge> demandeConges=new ArrayList<>();

        Database db =new Database("root", "","openrh");
        db.connect();

        try {
            db.sendQuery("SELECT * FROM demandeconge",resultSet -> {
                while(resultSet.next()){
                    demandeConges.add(new DemandeConge(resultSet.getString("mat_emp"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("date_depart"),resultSet.getString("date_retour"),resultSet.getString("piece_jointe"),resultSet.getString("type_conge"),resultSet.getString("motif")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        model.addAttribute("demandeConges",demandeConges);
        model.addAttribute("DemandeConge",demandeConge);

        return "demandeConge";
    }
}
