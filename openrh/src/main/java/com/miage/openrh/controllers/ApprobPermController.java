package com.miage.openrh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApprobPermController {
    @GetMapping(value ="/approbPerm")
    public String approbPerm(Model model){
        return "approbPerm";
    }
}

