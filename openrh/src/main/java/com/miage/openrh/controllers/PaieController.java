package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PaieController {

    @PostMapping(value = "/enregistrerpaie")
    public String enregistrerpaie(@ModelAttribute("paie") Paie paie, Model model) {
        try {
            paie.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return paie(model);
    }
    @GetMapping(value ="/paie")
    public String paie(Model model){
        Paie paie = new Paie();
        List<Paie> paies=new ArrayList<>();
        List<Mois> mois1 = new ArrayList<>();
        List<AjoutEmploye> ajoutEmployes = new ArrayList<>();
        Database db =new Database("root", "","openrh");
        db.connect();

        try {
            db.sendQuery("SELECT * FROM paie",resultSet -> {
                while(resultSet.next()){
                    paies.add(new Paie(resultSet.getString("mat_emp"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("poste"),resultSet.getString("mois"),resultSet.getInt("net_payer"),resultSet.getInt("salaire_base"),resultSet.getInt("sursalaire"),resultSet.getInt("prime_anciennete"),resultSet.getInt("contri_nationale"),resultSet.getInt("impot_salaire"),resultSet.getInt("impot_revenu"),resultSet.getInt("cnps")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }


        try {
            db.sendQuery("SELECT * FROM mois",resultSet -> {
                while(resultSet.next()){
                    mois1.add(new Mois(resultSet.getInt("id_mois"),resultSet.getString("lib_mois")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        try {
            db.sendQuery("SELECT * FROM ajoutemploye",resultSet -> {
                while(resultSet.next()){
                    ajoutEmployes.add(new AjoutEmploye(resultSet.getString("mat_emp"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("genre"),resultSet.getString("date_naiss"),resultSet.getString("photo"),resultSet.getString("lieu_naiss"),resultSet.getString("email"),resultSet.getString("numero"),resultSet.getString("situationMatri"),resultSet.getString("poste"),resultSet.getString("salaire")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        model.addAttribute("mois1",mois1);
        model.addAttribute("paies",paies);
        model.addAttribute("ajoutEmployes",ajoutEmployes);

        model.addAttribute("Paie",paie);

        return "paie";
    }
    @GetMapping("/paie/supprimer/")
    String del_emp(HttpServletRequest request, Model model) {

        Database db = new Database("root", "", "openrh");

        db.connect();

        try {

            db.sendQuery("DELETE FROM paie WHERE mat_emp =?", new ArrayList<Object>() {
                {
                    add(request.getParameter("del"));
                }
            }, resultSet -> {
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();

        return paie(model);

    }
}
