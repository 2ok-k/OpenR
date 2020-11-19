package com.miage.openrh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListeEmployeController {
    @GetMapping(value ="/listeEmploye")
    public String listeEmploye(){
        return "listeEmploye";
    }
}
