package com.miage.openrh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login1Controller {
    @GetMapping(value ="/login1")
    public String login1(Model model){
        return "login1";
    }
}
