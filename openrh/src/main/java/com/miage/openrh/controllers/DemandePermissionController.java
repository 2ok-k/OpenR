package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.Categorie;
import com.miage.openrh.models.DemandeConge;
import com.miage.openrh.models.DemandePermission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DemandePermissionController {

    @PostMapping(value = "/enregistrerDemandePerm")
    public String enregistrerDemandePerm(@ModelAttribute("demandePermission") DemandePermission demandePermission, Model model) {
        try {
            demandePermission.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return demandePermission(model);
    }


    @GetMapping(value ="/demandePermission")
    public String demandePermission(Model model){
        DemandePermission demandePermission = new DemandePermission();
        List<DemandePermission> demandePermissions=new ArrayList<>();

        Database db =new Database("root", "","openrh");
        db.connect();

        try {
            db.sendQuery("SELECT * FROM demandepermission",resultSet -> {
                while(resultSet.next()){
                    demandePermissions.add(new DemandePermission(resultSet.getString("mat_emp"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("date_depart"),resultSet.getString("date_retour"),resultSet.getString("motif")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        model.addAttribute("demandePermissions",demandePermissions);
        model.addAttribute("DemandePermission",demandePermission);

        return "demandePermission";
    }
}
