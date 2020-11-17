package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.Genre;
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
public class StructureController {
    @PostMapping(value = "/enregistrerstructure")
    public String enregistrerstructure(@ModelAttribute("structure") Structure structure, Model model) {
        try {
            structure.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return structure(model);
    }


    @GetMapping(value = "/structure")
    public String structure(Model model) {
        Structure structure = new Structure();
        List<Structure> structures = new ArrayList<>();
        Database db = new Database("root", "", "openrh");
        db.connect();

        try {
            db.sendQuery("SELECT * FROM structure", resultSet -> {
                while (resultSet.next()) {
                    structures.add(new Structure(resultSet.getInt("cod_struct"), resultSet.getString("lib_struct")));
                }
            });

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        model.addAttribute("structures", structures);

        model.addAttribute("Structure", structure);

        return "structure";
    }

    @GetMapping("/structure/supprimer/")
    String del_struct(HttpServletRequest request, Model model) {

        Database db = new Database("root", "", "openrh");

        db.connect();

        try {

            db.sendQuery("DELETE FROM structure WHERE cod_struct=?", new ArrayList<Object>() {
                {
                    add(request.getParameter("del"));
                }
            }, resultSet -> {
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();

        return structure(model);

    }
}