package com.alexcompany.springsecurity62.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

//    @GetMapping({"/", "/index", "/logout"})
//    public String index(){
//        return "index";
//    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "profile";
    }

}
