package com.project.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspRender {

    @GetMapping("/index")
    public String renderIndex(){
        return "index";
    }

    @GetMapping("/login")
    public String renderLogin(){
        return "login";
    }

    @GetMapping("/registration")
    public String renderRegister() {
        return "registration";
    }
}
