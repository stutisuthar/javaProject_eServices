package com.project.services.controller;

import com.project.services.model.Location;
import com.project.services.model.Service;
import com.project.services.model.ServiceProvider;
import com.project.services.model.UserDetails;
import com.project.services.repository.ServiceProviderRepository;
import com.project.services.repository.userDetailsRepository;
import com.project.services.repository.LocationRepository;
// import com.project.services.service.ServiceService;
import com.project.services.service.addServiceToDB;
import com.project.services.service.userDetailsService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

// Session Management
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class UIController {

    @Autowired
    private LocationRepository locationRepo;
    @Autowired
    private userDetailsService userService;
    @Autowired
    private addServiceToDB addingService;
    @Autowired
    private ServiceProviderRepository serviceProviderRepo;
    @Autowired
    private userDetailsRepository userRepo;

    @GetMapping("/")
    public String renderRoot(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("userName") != null) {
            return "redirect:/landing";
        } else {
            UserDetails user = new UserDetails();
            model.addAttribute("user", user);
            return "redirect:/login";
        }
    }

    @GetMapping("/index")
    public String renderIndex(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("userName") != null) {
            return "redirect:/landing";
        } else {
            UserDetails user = new UserDetails();
            model.addAttribute("user", user);
            return "redirect:/login";
        }
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

        // System.out.println("\n Service Providers \n\t");
        // serviceList.forEach(data -> System.out.println(data.getContact_number()));
        if(request.getSession().getAttribute("userName")!=null){
            String user = request.getSession().getAttribute("userName").toString();
            int userId = Integer.parseInt(user);
            String userName = userRepo.findById(userId).getName();
            model.addAttribute("userName", userName);
            List<ServiceProvider> serviceList = serviceProviderRepo.findAll();
            model.addAttribute("serviceList", serviceList);
            return "landing";
        }else{
            return "redirect:/forbidden";
        }
    }

    @GetMapping("/navbar")
    public String renderNavbar(Model model, HttpServletRequest request) {
        String user = request.getSession().getAttribute("userName").toString();
        int userId = Integer.parseInt(user); 
        String userName = userRepo.findById(userId).getName();
        model.addAttribute("userName", userName);
        return "navbar";
    }

    // Curretly using all the service ( Ordered and not ordered ) in "Your orders" inside userProfile

    @GetMapping("/userProfile")
    public String renderUserProfile(Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("userName")!=null) {
            List<ServiceProvider> serviceList = serviceProviderRepo.findAll();
            String user = request.getSession().getAttribute("userName").toString();
            int userId = Integer.parseInt(user);
            String userName = userRepo.findById(userId).getName();
            model.addAttribute("userName", userName);
            model.addAttribute("userName", userName);
            model.addAttribute("serviceList", serviceList);
            return "userProfile";
        }
        else {
            return "redirect:/forbidden";
        }
    }


    // @GetMapping("/services")
    // public String renderService() {
    //     return "service";
    // }

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

    @PostMapping("/signout")
    public String signOut(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    // @PostMapping(value = "/services/", consumes =
    // MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    // "application/x-www-form-urlencoded"
    // @PostMapping("/services/")
    // public String renderService(@ModelAttribute("service") ServiceProvider
    // service, Model model) {
    // // public String rendService(@RequestBody Map<String, String> params, Model
    // // model) {
    // // public String renderService(@ModelAttribute("service") ServiceProvider
    // // service, Model model) {
    // System.out.println(service.getId());
    // // ServiceProvider service = serviceProviderRepo.findById(id);
    // // model.addAttribute("service", service);
    // return "service";
    // }
    
    // @PostMapping(value)


    // @RequestMapping(value = "/services/{srvid}", params = { "srvid" })
    // @GetMapping("/services")
    // public String renderServices(){
    // public String renderService(@PathVariable("srvId") int srvId, ServiceProvider service, BindingResult bindingResult, HttpServletRequest req) {
        // Integer serviceId = Integer.valueOf(req.getParameter("srvid"));
        // System.out.println(srvId);
        // ServiceProvider serviceP = new ServiceProvider();
        // serviceP = serviceProviderRepo.findById(srvId);
        // System.out.println(serviceP);
    //     return "service";
    // }

    @PostMapping("/register")
    public String submitUser(@ModelAttribute("user") UserDetails user) {
        System.out.println(user.getName());
        userService.SaveUserData(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String submitLogin(@ModelAttribute("user") UserDetails user, HttpServletRequest request) {
        // System.out.println(user.getName());
        int signedUser = userService.AuthenticateUser(user);
        System.out.println(signedUser);
        if (signedUser == 0) {
            System.out.println("invalid User");
            return "login";
        } else if (signedUser == -1) {
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

    @GetMapping("/service/{srvId}")
    public String renderServices(@PathVariable("srvId") int srvId,Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("userName")!=null){
            System.out.println(srvId);
            String user = request.getSession().getAttribute("userName").toString();
            int userId = Integer.parseInt(user);
            String userName = userRepo.findById(userId).getName();
            model.addAttribute("userName", userName);
            ServiceProvider serviceP = new ServiceProvider();
            serviceP = serviceProviderRepo.findById(srvId);
            System.out.println(serviceP);
            if(serviceP==null){
                return "redirect:/error";
            }
            model.addAttribute("service", serviceP);
            return "service";
        }else{
            return "redirect:/forbidden";
        }
    }

    @GetMapping("/addService")
    public String renderAdminAddService(Model model) {
        ServiceProvider service = new ServiceProvider();
        model.addAttribute("service", service);
        Location location = new Location();
        // String loca = null;
        model.addAttribute("location", location);
        List<Location> list = locationRepo.findAll();
        model.addAttribute("cities", list);
        System.out.println("testing" + list);
        return "adminAddService";
    }

    @PostMapping("/addService")
    public String addServiceToDB(@ModelAttribute("service") ServiceProvider service,
            @ModelAttribute("location") Location location) {
        System.out.println("test1:\t " + location.toString());
        addingService.SaveServicesData(service, location);
        return "redirect:/addService";
    }

    @GetMapping("/adminNavbar")
    public String renderAdminNavBar() {
        return "adminNavbar";
    }
  
   
    // @GetMapping("/error")
    // public String renderError() {
    //     return "error";
    // }

    @GetMapping("/forbidden")
    public String render403() {
        return "forbidden";
    }
}