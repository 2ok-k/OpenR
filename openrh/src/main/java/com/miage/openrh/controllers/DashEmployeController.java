package com.miage.openrh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashEmployeController {
    @GetMapping(value ="/dashEmploye")
    public String dashEmploye(){
        return "dashEmploye";
    }
}
