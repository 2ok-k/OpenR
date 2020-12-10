package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.Genre;
import com.miage.openrh.models.Mois;
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
public class MoisController {
    @PostMapping(value = "/enregistrermois")
    public String enregistrermois(@ModelAttribute("mois") Mois mois, Model model) {
        try {
            mois.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return mois(model);
    }

    @GetMapping(value ="/mois")
    public String mois(Model model){
        Mois mois = new Mois();
        List<Mois> mois1=new ArrayList<>();
        Database db =new Database("root", "","openrh");
        db.connect();

        try {
            db.sendQuery("SELECT * FROM mois",resultSet -> {
                while(resultSet.next()){
                    mois1.add(new Mois(resultSet.getInt("id_mois"),resultSet.getString("lib_mois")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        model.addAttribute("mois1",mois1);

        model.addAttribute("Mois",mois);

        return "mois";
    }
    @GetMapping("/mois/supprimer/")
    String del_mois(HttpServletRequest request, Model model) {

        Database db = new Database("root", "", "openrh");

        db.connect();

        try {

            db.sendQuery("DELETE FROM mois WHERE id_mois=?", new ArrayList<Object>() {
                {
                    add(request.getParameter("del"));
                }
            }, resultSet -> {
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();

        return mois(model);

    }
}
