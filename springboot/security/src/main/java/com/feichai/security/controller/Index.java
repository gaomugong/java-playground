package com.feichai.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("username", "pitou");
        return "index";
    }
}
