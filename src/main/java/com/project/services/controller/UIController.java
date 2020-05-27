package com.project.services.controller;

import com.project.services.model.Service;
import com.project.services.model.UserDetails;
// import com.project.services.service.ServiceService;
import com.project.services.service.userDetailsService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

// Session Management
import javax.servlet.http.HttpServletRequest;

@Controller
public class UIController {

    @Autowired
    // private ServiceService eService;
    private userDetailsService userService;
    // private Service user;

    @GetMapping("/index")
    public String renderIndex() {
        return "login";
    }

    @GetMapping("/login")
    public String renderLogin(Model model) {
        UserDetails user = new UserDetails();
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/registration")
    public String renderRegister(Model model) {
        UserDetails user = new UserDetails();
        model.addAttribute("user", user);
        return "registration";
    }

    @GetMapping("/landing")
    public String renderLanding(Model model, HttpServletRequest request) {
        String userName =(String)request.getSession().getAttribute("userName");
        model.addAttribute("userName", userName);
        return "landing";
    }

    @GetMapping("/service")
    public String renderService() {
        return "service";
    }


    // @GetMapping("/test")
    // public String renderTest(@RequestParam(name = "name", required = false,
    // defaultValue = "World") String name,Model model){
    // model.addAttribute("name", name);
    // return "test";
    // }
    @GetMapping("/test")
    public String renderTest(Model model) {
        Service user = new Service();
        model.addAttribute("user", user);
        return "test";
    }

    @PostMapping("/register")
    public String submitUser(@ModelAttribute("user") UserDetails user) {
        System.out.println(user.getName());
        userService.SaveUserData(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String submitLogin(@ModelAttribute("user") UserDetails user, HttpServletRequest request) {
        // System.out.println(user.getName());
        String signedUser = userService.AuthenticateUser(user);
        if(signedUser!="false"){
            request.getSession().setAttribute("userName", signedUser);
            System.out.println(request.getSession().getAttribute("userName"));
            return "redirect:/landing";
        }
        else{
            return "login";
        }
        
    }
}