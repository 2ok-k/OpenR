package com.miage.openrh.controllers;

import com.miage.openrh.Database;
import com.miage.openrh.models.Genre;
import com.miage.openrh.models.Pays;
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
public class GenreController {

    @PostMapping(value = "/enregistrergenre")
    public String enregistrergenre(@ModelAttribute("genre") Genre genre, Model model) {
        try {
            genre.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return genre(model);
    }


    @GetMapping(value ="/genre")
    public String genre(Model model){
        Genre genre = new Genre();
        List<Genre> genres=new ArrayList<>();
        Database db =new Database("root", "","openrh");
        db.connect();

        try {
            db.sendQuery("SELECT * FROM genre",resultSet -> {
                while(resultSet.next()){
                    genres.add(new Genre(resultSet.getInt("id_genre"),resultSet.getString("lib_genre")));
                }
            });

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        model.addAttribute("genres",genres);

        model.addAttribute("Genre",genre);

        return "genre";
    }
    @GetMapping("/genre/supprimer/")
    String del_genre(HttpServletRequest request, Model model) {

        Database db = new Database("root", "", "openrh");

        db.connect();

        try {

            db.sendQuery("DELETE FROM genre WHERE id_genre=?", new ArrayList<Object>() {
                {
                    add(request.getParameter("del"));
                }
            }, resultSet -> {
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();

        return genre(model);

    }
}
