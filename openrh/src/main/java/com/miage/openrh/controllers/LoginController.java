package com.miage.openrh.controllers;

import com.miage.openrh.models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {


    @GetMapping(value ="/login")
    public String login(Model model){
        model.addAttribute("user",new Users());
        return "login";
    }

    @PostMapping("/verify")
    String pageAppropriee(@ModelAttribute("users") Users users) {
        if (users.exist()) {

            return "dashAdmin";
        } else {
            return "login";
        }
    }
}
