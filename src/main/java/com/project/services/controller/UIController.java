package com.project.services.controller;

import com.project.services.model.Service;
import com.project.services.model.ServiceProvider;
import com.project.services.model.UserDetails;
import com.project.services.repository.ServiceProviderRepository;
// import com.project.services.repository.LocationRepository;
// import com.project.services.service.ServiceService;
import com.project.services.service.addServiceToDB;
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
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UIController {

    // @Autowired
    // private LocationRepository locationRepo;
    @Autowired
    private userDetailsService userService;
    @Autowired
    private addServiceToDB addingService;
    @Autowired
    private ServiceProviderRepository serviceProviderRepo;
    // @Autowired
    // private Location location;

    @GetMapping("/")
    public String renderRoot(Model model) {
        UserDetails user = new UserDetails();
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/index")
    public String renderIndex(Model model) {
        UserDetails user = new UserDetails();
        model.addAttribute("user", user);
        return "redirect:/login";
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
        System.out.println("\n Service Providers \n\t");
        List<ServiceProvider> serviceList = serviceProviderRepo.findAll();
        // serviceList.forEach(data -> System.out.println(data.getContact_number()));
        String userName = (String) request.getSession().getAttribute("userName");
        model.addAttribute("userName", userName);
        model.addAttribute("serviceList", serviceList);
        return "landing";
    }

    @GetMapping("/service")
    public String renderService() {
        return "service";
    }

    @GetMapping("/navbar")
    public String renderNavbar(Model model, HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        model.addAttribute("userName", userName);
        return "navbar";
    }

    @PostMapping("/signout")
    public String signOut(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
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
        System.out.println(signedUser);
        if (signedUser == "invalid") {
            System.out.println("invalid User");
            return "login";
        } else if (signedUser == "error") {
            return "login";
        } else {
            request.getSession().setAttribute("userName", signedUser);
            System.out.println(request.getSession().getAttribute("userName"));
            return "redirect:/landing";
        }

    }

    // admin URLS mapping

    @GetMapping("/adminLogin")
    public String renderAdminLogin() {
        return "adminLogin";
    }

    @GetMapping("/dashboard")
    public String renderAdminDashboard() {
        return "adminDashboard";
    }

    @GetMapping("/addService")
    public String renderAdminAddService(Model model) {
        ServiceProvider service = new ServiceProvider();
        model.addAttribute("service", service);
        return "adminAddService";
    }

    @PostMapping("/addService")
    public String addServiceToDB(@ModelAttribute("service") ServiceProvider service) {
        addingService.SaveServicesData(service);
        // try {
        // System.out.println(locationRepo.findAll());
        // service.setLocation(locationRepo.findById(3));
        // System.out.println("Service:\t"+service.toString());
        // System.out.println(service.getLocation().getLocName());
        // serviceProviderRepo.save(service);
        // } catch (Exception e) {
        // System.out.println(e);
        // }
        return "adminAddService";
    }

    @GetMapping("/adminNavbar")
    public String renderAdminNavBar() {
        return "adminNavbar";
    }

}