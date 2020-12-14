package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.AjoutEmploye;
import com.miage.openrh.models.Categorie;
import com.miage.openrh.models.Genre;
import com.miage.openrh.models.SituationMatri;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        List<AjoutEmploye> ajoutEmployes=new ArrayList<>();
        List<Genre> genres = new ArrayList<>();
        List<SituationMatri> situationMatris=new ArrayList<>();
        Database db =new Database("root", "","openrh");
        db.connect();

        try {
            db.sendQuery("SELECT * FROM ajoutemploye",resultSet -> {
                while(resultSet.next()){
                    ajoutEmployes.add(new AjoutEmploye(resultSet.getString("mat_emp"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("genre"),resultSet.getString("date_naiss"),resultSet.getString("photo"),resultSet.getString("lieu_naiss"),resultSet.getString("email"),resultSet.getString("numero"),resultSet.getString("situationMatri"),resultSet.getString("poste"),resultSet.getString("salaire")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }


        try {
            db.sendQuery("SELECT * FROM genre",resultSet -> {
                while(resultSet.next()){
                    genres.add(new Genre(resultSet.getInt("id_genre"),resultSet.getString("lib_genre")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }


        try {
            db.sendQuery("SELECT * FROM situationmatri",resultSet -> {
                while(resultSet.next()){
                    situationMatris.add(new SituationMatri(resultSet.getInt("id_sit"),resultSet.getString("lib_sit")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        
        model.addAttribute("situationMatris",situationMatris);
        model.addAttribute("genres",genres);
        model.addAttribute("ajoutEmployes",ajoutEmployes);

        model.addAttribute("AjoutEmploye",ajoutEmploye);

        return "ajoutEmploye";
    }
}
