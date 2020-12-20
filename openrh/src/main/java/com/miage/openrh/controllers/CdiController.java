package com.miage.openrh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CdiController {
    @GetMapping(value ="/cdi")
    public String cdd(Model model){
        return "cdi";
    }
}
