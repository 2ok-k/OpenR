package com.miage.openrh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dashAdminController {
    @GetMapping(value ="/dashAdmin")
    public String dashAdmin(){
        return "dashAdmin";
    }
}
