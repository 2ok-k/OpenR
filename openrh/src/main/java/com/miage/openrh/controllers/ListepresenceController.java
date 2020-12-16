package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.AjoutEmploye;
import com.miage.openrh.models.Presence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ListepresenceController {
    @GetMapping(value ="/listepresence")
    public String listepresence(Model model){
        List<Presence> presences=new ArrayList<>();

        Database db =new Database("root", "","openrh");
        db.connect();
        try {
            db.sendQuery("SELECT * FROM presence",resultSet -> {
                while(resultSet.next()){
                    presences.add(new Presence(resultSet.getString("mat_emp"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("date"),resultSet.getString("heure_arrive")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        model.addAttribute("presences",presences);

        return "listepresence";
    }
    @GetMapping("/listepresence/supprimer/")
    String del_emp(HttpServletRequest request, Model model) {

        Database db = new Database("root", "", "openrh");

        db.connect();

        try {

            db.sendQuery("DELETE FROM presence WHERE mat_emp =?", new ArrayList<Object>() {
                {
                    add(request.getParameter("del"));
                }
            }, resultSet -> {
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();

        return listepresence(model);

    }
}
