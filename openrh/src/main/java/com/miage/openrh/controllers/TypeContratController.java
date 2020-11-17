package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.Structure;
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
public class TypeContratController {
    @PostMapping(value = "/enregistrertypecontrat")
    public String enregistrertypecontrat(@ModelAttribute("typeContrat") TypeContrat typeContrat, Model model) {
        try {
            typeContrat.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return typeContrat(model);
    }


    @GetMapping(value ="/typeContrat")
    public String typeContrat(Model model){
        TypeContrat typeContrat = new TypeContrat();
        List<TypeContrat> typeContrats=new ArrayList<>();
        Database db =new Database("root", "","openrh");
        db.connect();

        try {
            db.sendQuery("SELECT * FROM typecontrat",resultSet -> {
                while(resultSet.next()){
                    typeContrats.add(new TypeContrat(resultSet.getInt("id_type_contrat"),resultSet.getString("lib_contrat")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        model.addAttribute("typeContrats",typeContrats);

        model.addAttribute("TypeContrat",typeContrat);

        return "typeContrat";
    }
    @GetMapping("/typeContrat/supprimer/")
    String del_typContr(HttpServletRequest request, Model model) {

        Database db = new Database("root", "", "openrh");

        db.connect();

        try {

            db.sendQuery("DELETE FROM typecontrat WHERE id_type_contrat=?", new ArrayList<Object>() {
                {
                    add(request.getParameter("del"));
                }
            }, resultSet -> {
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();

        return typeContrat(model);

    }
}
