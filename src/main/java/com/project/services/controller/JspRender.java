package com.project.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspRender {

    @GetMapping("/jsp")
    public String render(){
        return "index";
    }
}
