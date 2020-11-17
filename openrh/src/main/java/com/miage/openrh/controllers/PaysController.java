package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.Genre;
import com.miage.openrh.models.Pays;
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

        model.addAttribute("pays1",pays1);

        model.addAttribute("Pays",pays);

        return "pays";
    }
    @GetMapping("/pays/supprimer/")
    String del_pays(HttpServletRequest request, Model model) {

        Database db = new Database("root", "", "openrh");

        db.connect();

        try {

            db.sendQuery("DELETE FROM pays WHERE id_pays=?", new ArrayList<Object>() {
                {
                    add(request.getParameter("del"));
                }
            }, resultSet -> {
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();

        return pays(model);

    }
}
