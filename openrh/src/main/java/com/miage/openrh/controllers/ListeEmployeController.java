package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.AjoutEmploye;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ListeEmployeController {
    @GetMapping(value ="/listeEmploye")
    public String listeEmploye(Model model){
        List<AjoutEmploye> ajoutEmployes=new ArrayList<>();

        Database db =new Database("root", "","openrh");
        db.connect();
        try {
            db.sendQuery("SELECT * FROM ajoutemploye",resultSet -> {
                while(resultSet.next()){
                    ajoutEmployes.add(new AjoutEmploye(resultSet.getString("mat_emp"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("genre"),resultSet.getString("date_naiss"),resultSet.getString("photo"),resultSet.getString("lieu_naiss"),resultSet.getString("email"),resultSet.getString("numero"),resultSet.getString("situationMatri"),resultSet.getString("poste"),resultSet.getString("salaire")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        model.addAttribute("ajoutEmployes",ajoutEmployes);
        //model.addAttribute("ListeEmploye",listeEmploye);

        return "listeEmploye";
    }
    @GetMapping("/listeEmploye/supprimer/")
    String del_emp(HttpServletRequest request, Model model) {

        Database db = new Database("root", "", "openrh");

        db.connect();

        try {

            db.sendQuery("DELETE FROM ajoutemploye WHERE mat_emp =?", new ArrayList<Object>() {
                {
                    add(request.getParameter("del"));
                }
            }, resultSet -> {
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();

        return listeEmploye(model);

    }
}
