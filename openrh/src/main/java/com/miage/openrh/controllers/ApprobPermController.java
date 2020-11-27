package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.DemandeConge;
import com.miage.openrh.models.DemandePermission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ApprobPermController {
    @GetMapping(value ="/approbPerm")
    public String approbPerm(Model model){
        List<DemandePermission> demandePermissions=new ArrayList<>();
        List<DemandePermission> dems=new ArrayList<>();

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
        try {
            db.sendQuery("SELECT * FROM demandepermission WHERE approbation=true ",resultSet -> {
                while(resultSet.next()){
                    dems.add(new DemandePermission(resultSet.getString("mat_emp"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("date_depart"),resultSet.getString("date_retour"),resultSet.getString("motif")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        model.addAttribute("dems",dems);
        model.addAttribute(" demandePermissions", demandePermissions);

        return "approbPerm";
    }
    @GetMapping(value = "/demandePermission/valider/")
    String val_dem(HttpServletRequest request, Model model){
        Database db = new Database("root", "","openrh");

        db.connect();

        try {

            db.sendQuery("UPDATE demandepermission SET approbation=true WHERE mat_emp=?", new ArrayList<Object>() {
                {
                    add(request.getParameter("val"));
                }
            }, resultSet -> {});
        }catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();
        return approbPerm(model);
    }
}

