package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.Categorie;
import com.miage.openrh.models.Entreprise;
import com.miage.openrh.models.TypeContrat;
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
public class CategorieController {
    @PostMapping(value = "/enregistrercategorie")
    public String enregistrercategorie(@ModelAttribute("categorie") Categorie categorie, Model model) {
        try {
            categorie.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return categorie(model);
    }


    @GetMapping(value ="/categorie")
    public String categorie(Model model){
        Categorie categorie = new Categorie();
        List<Categorie> categories=new ArrayList<>();
        Database db =new Database("root", "","openrh");
        db.connect();

        try {
            db.sendQuery("SELECT * FROM categorie",resultSet -> {
                while(resultSet.next()){
                    categories.add(new Categorie(resultSet.getInt("id_cat"),resultSet.getString("lib_cat")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        model.addAttribute("categories",categories);

        model.addAttribute("Categorie",categorie);

        return "categorie";
    }
    @GetMapping("/categorie/supprimer/")
    String del_cat(HttpServletRequest request, Model model) {

        Database db = new Database("root", "", "openrh");

        db.connect();

        try {

            db.sendQuery("DELETE FROM categorie WHERE id_cat=?", new ArrayList<Object>() {
                {
                    add(request.getParameter("del"));
                }
            }, resultSet -> {
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();

        return categorie(model);

    }
}
