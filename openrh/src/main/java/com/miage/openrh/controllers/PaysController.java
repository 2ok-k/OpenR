package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.Genre;
import com.miage.openrh.models.Pays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PaysController {

    @PostMapping(value = "/enregistrerpays")
    public String enregistrerpays(@ModelAttribute("pays") Pays pays, Model model) {
        try {
            pays.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return pays(model);
    }


    @GetMapping(value ="/pays")
    public String pays(Model model){
        Pays pays = new Pays();
        List<Pays> pays1=new ArrayList<>();
        Database db =new Database("root", "","openrh");
        db.connect();

        try {
            db.sendQuery("SELECT * FROM pays",resultSet -> {
                while(resultSet.next()){
                    pays1.add(new Pays(resultSet.getInt("id_pays"),resultSet.getString("lib_pays")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        model.addAttribute("Pays",pays);
        model.addAttribute("pays1",pays1);

        return "pays";
    }
}
