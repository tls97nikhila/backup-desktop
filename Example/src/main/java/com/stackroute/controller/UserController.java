package com.stackroute.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
    @RequestMapping("/index")
    public String greet(Model model){
        User user = new User("Talla");
        model.addAttribute("name", user.getName());
        return "index";
    }
}
