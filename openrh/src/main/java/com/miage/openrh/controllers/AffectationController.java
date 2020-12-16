package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.Affectation;
import com.miage.openrh.models.AjoutEmploye;
import com.miage.openrh.models.Structure;
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
public class AffectationController {
    @PostMapping(value = "/enregistreraffect")
    public String enregistreraffect(@ModelAttribute("affectation") Affectation affectation, Model model) {
        try {
            affectation.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return affectation(model);
    }
    @GetMapping(value ="/affectation")

    public String affectation(Model model){
        Affectation affectation = new Affectation();
        List<Affectation> affectations=new ArrayList<>();
        List<Structure> structures = new ArrayList<>();
        List<AjoutEmploye> ajoutEmployes=new ArrayList<>();

        Database db =new Database("root", "","openrh");
        db.connect();

        try {
            db.sendQuery("SELECT * FROM affectation",resultSet -> {
                while(resultSet.next()){
                    affectations.add(new Affectation(resultSet.getString("mat_emp"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("structure_anterieur"),resultSet.getString("nouvelle_structure")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }


        try {
            db.sendQuery("SELECT * FROM structure", resultSet -> {
                while (resultSet.next()) {
                    structures.add(new Structure(resultSet.getInt("cod_struct"), resultSet.getString("lib_struct")));
                }
            });

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            db.sendQuery("SELECT * FROM ajoutemploye",resultSet -> {
                while(resultSet.next()){
                    ajoutEmployes.add(new AjoutEmploye(resultSet.getString("mat_emp"),resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("genre"),resultSet.getString("date_naiss"),resultSet.getString("photo"),resultSet.getString("lieu_naiss"),resultSet.getString("email"),resultSet.getString("numero"),resultSet.getString("situationMatri"),resultSet.getString("poste"),resultSet.getString("salaire")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        model.addAttribute("affectations",affectations);
        model.addAttribute("structures", structures);
        model.addAttribute("ajoutEmployes",ajoutEmployes);

        model.addAttribute("Affectation",affectation);

        return "affectation";
    }


    @GetMapping("/affectation/supprimer/")
    String del_emp(HttpServletRequest request, Model model) {

        Database db = new Database("root", "", "openrh");

        db.connect();

        try {

            db.sendQuery("DELETE FROM affectation WHERE mat_emp =?", new ArrayList<Object>() {
                {
                    add(request.getParameter("del"));
                }
            }, resultSet -> {
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();

        return affectation(model);

    }
}
