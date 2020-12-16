package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.AjoutEmploye;
import com.miage.openrh.models.DemandePermission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DashEmployeController {
    @GetMapping(value ="/dashEmploye")
    public String dashEmploye(Model model){
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

        return "dashEmploye";
    }
}
