package com.miage.openrh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApprobationCongeController {


    @GetMapping(value ="/approbationConge")
    public String approbationConge(Model model){

        return "approbationConge";
    }
}