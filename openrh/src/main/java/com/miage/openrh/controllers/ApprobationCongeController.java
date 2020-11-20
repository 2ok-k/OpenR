package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.DemandeConge;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ApprobationCongeController {


    @GetMapping(value ="/approbationConge")
    public String approbationConge(Model model){
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

        return "approbationConge";
    }
    @GetMapping(value = "/demandeConge/valider/")
    String val_dem(HttpServletRequest request, Model model){
        Database db = new Database("root", "","openrh");

        db.connect();

        try {

            db.sendQuery("UPDATE demandeconge SET approbation=true WHERE mat_emp=?", new ArrayList<Object>() {
                {
                    add(request.getParameter("val"));
                }
            }, resultSet -> {});
        }catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();
        return approbationConge(model);
    }
}