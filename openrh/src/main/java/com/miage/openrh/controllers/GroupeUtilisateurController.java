package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.GroupeUtilisateur;
import com.miage.openrh.models.SituationMatri;
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
public class GroupeUtilisateurController {
    @PostMapping(value = "/enregistrergrpeUsers")
    public String enregistrergrpeUsers(@ModelAttribute("groupeUtilisateur") GroupeUtilisateur groupeUtilisateur, Model model) {
        try {
            groupeUtilisateur.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return groupeUtilisateur(model);
    }


    @GetMapping(value ="/groupeUtilisateur")
    public String groupeUtilisateur(Model model){
        GroupeUtilisateur groupeUtilisateur = new GroupeUtilisateur();
        List<GroupeUtilisateur> groupeUtilisateurs=new ArrayList<>();
        Database db =new Database("root", "","openrh");
        db.connect();

        try {
            db.sendQuery("SELECT * FROM groupeutilisateur",resultSet -> {
                while(resultSet.next()){
                    groupeUtilisateurs.add(new GroupeUtilisateur(resultSet.getInt("id_grpUt"),resultSet.getString("lib_grpUt")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        model.addAttribute("groupeUtilisateurs",groupeUtilisateurs);

        model.addAttribute("GroupeUtilisateur",groupeUtilisateur);

        return "groupeUtilisateur";
    }
    @GetMapping("/groupeUtilisateur/supprimer/")
    String del_grpeUser(HttpServletRequest request, Model model) {

        Database db = new Database("root", "", "openrh");

        db.connect();

        try {

            db.sendQuery("DELETE FROM groupeutilisateur WHERE id_grpUt=?", new ArrayList<Object>() {
                {
                    add(request.getParameter("del"));
                }
            }, resultSet -> {
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();

        return groupeUtilisateur(model);

    }
}
