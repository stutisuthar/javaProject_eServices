package com.project.services.controller;

import com.project.services.model.Service;
import com.project.services.service.ServiceService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class UIController{

    @Autowired
    private ServiceService eservice;
    private Service user;
    
    @GetMapping("/index")
    public String renderIndex(){
        return "index";
    }

    @GetMapping("/login")
    public String renderLogin(){
        return "login";
    }

    @GetMapping("/registration")
    public String renderRegister(){
        return "registration";
    }

    // @GetMapping("/test")
    // public String renderTest(@RequestParam(name = "name", required = false, defaultValue = "World") String name,Model model){
    //     model.addAttribute("name", name);
    //     return "test";
    // }
    @GetMapping("/test")
    public String renderTest(Model model) {
        Service user = new Service();
        model.addAttribute("user", user);
        return "test";
    }
    
    @PostMapping("/test")
    public String submitUser(@ModelAttribute("user") Service user){
        System.out.println(user.getName());
        // user = (Map<String,String>)user;
        eservice.SaveData(user);
        return "login";
    }
}
