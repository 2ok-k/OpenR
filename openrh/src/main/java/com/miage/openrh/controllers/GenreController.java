package com.miage.openrh.controllers;

import com.miage.openrh.models.Genre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
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

        model.addAttribute("Genre",genre);

        return "genre";
    }
}
