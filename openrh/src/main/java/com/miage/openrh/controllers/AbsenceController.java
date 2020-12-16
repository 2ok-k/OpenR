package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.Absence;
import com.miage.openrh.models.AjoutEmploye;
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
public class AbsenceController {

    @PostMapping(value = "/enregistrerabs")
    public String enregistrerabs(@ModelAttribute("absence") Absence absence, Model model) {
        try {
            absence.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return absence(model);
    }
    @GetMapping(value ="/absence")

    public String absence(Model model){
        Absence absence = new Absence();
        List<Absence> absences=new ArrayList<>();
        List<AjoutEmploye> ajoutEmployes = new ArrayList<>();
        Database db =new Database("root", "","openrh");
        db.connect();

        try {
            db.sendQuery("SELECT * FROM absence",resultSet -> {
                while(resultSet.next()){
                    absences.add(new Absence(resultSet.getString("mat_emp"),resultSet.getString("nom"),resultSet.getString("date_absence"),resultSet.getInt("duree")));
                }
            });

        }catch (SQLException throwables){
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
        model.addAttribute("absences",absences);
        model.addAttribute("ajoutEmployes",ajoutEmployes);

        model.addAttribute("Absence",absence);

        return "absence";
    }


    @GetMapping("/absence/supprimer/")
    String del_emp(HttpServletRequest request, Model model) {

        Database db = new Database("root", "", "openrh");

        db.connect();

        try {

            db.sendQuery("DELETE FROM absence WHERE mat_emp =?", new ArrayList<Object>() {
                {
                    add(request.getParameter("del"));
                }
            }, resultSet -> {
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();

        return absence(model);

    }
}
