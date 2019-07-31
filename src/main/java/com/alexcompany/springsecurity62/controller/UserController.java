package com.alexcompany.springsecurity62.controller;

import com.alexcompany.springsecurity62.dto.UserDTO;
import com.alexcompany.springsecurity62.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(@RequestParam(name = "error", defaultValue = "false") String hasError,
                        Model model){
        if(Boolean.valueOf(hasError)){
            model.addAttribute("error", "Invalid username or password");
        }
        return "login";
    }
    @GetMapping("/registration")
    public String register(Model model){
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute(name = "user") @Valid UserDTO user, BindingResult result,
                           WebRequest webRequest, Errors errors,
                           Model model){
        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "/register";
        }
        userService.registerNewUser(user);
        return "redirect:/index";
    }

}
