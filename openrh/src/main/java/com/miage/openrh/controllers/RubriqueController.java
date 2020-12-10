package com.miage.openrh.controllers;


import com.miage.openrh.Database;
import com.miage.openrh.models.Mois;
import com.miage.openrh.models.Rubrique;
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
public class RubriqueController {
    @PostMapping(value = "/enregistrerrub")
    public String enregistrerrub(@ModelAttribute("rubrique") Rubrique rubrique, Model model) {
        try {
            rubrique.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rubrique(model);
    }

    @GetMapping(value ="/rubrique")
    public String rubrique(Model model){
        Rubrique rubrique = new Rubrique();
        List<Rubrique> rubriques=new ArrayList<>();
        Database db =new Database("root", "","openrh");
        db.connect();

        try {
            db.sendQuery("SELECT * FROM rubrique",resultSet -> {
                while(resultSet.next()){
                    rubriques.add(new Rubrique(resultSet.getInt("id_rub"),resultSet.getString("lib_rub")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        model.addAttribute("rubriques",rubriques);

        model.addAttribute("Rubrique",rubrique);

        return "rubrique";
    }
    @GetMapping("/rubrique/supprimer/")
    String del_rub(HttpServletRequest request, Model model) {

        Database db = new Database("root", "", "openrh");

        db.connect();

        try {

            db.sendQuery("DELETE FROM rubrique WHERE id_rub=?", new ArrayList<Object>() {
                {
                    add(request.getParameter("del"));
                }
            }, resultSet -> {
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();

        return rubrique(model);

    }
}
