package com.project.services.controller;

// import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.project.services.model.Location;
import com.project.services.model.OrderDetails;
import com.project.services.model.Service;
import com.project.services.model.ServiceProvider;
import com.project.services.model.UserDetails;
import com.project.services.repository.ServiceProviderRepository;
import com.project.services.repository.UserProfileDetailsRepo;
import com.project.services.repository.userDetailsRepository;
import com.project.services.repository.LocationRepository;
import com.project.services.repository.OrderDetailsRepository;
// import com.project.services.service.ServiceService;
import com.project.services.service.addServiceToDB;
import com.project.services.service.userDetailsService;

import com.project.services.forms.*;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.MediaType;

// Session Management
// import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;
// import java.util.Map;
// import java.util.Optional;
import java.util.Set;

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
    @Autowired
    private UserProfileDetailsRepo userProfile;
    @Autowired
    private OrderDetailsRepository orderDetailsRepo;

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
        // System.out.println("URI"+request.getQueryString()+" "+request.getParameter("search"));
        // System.out.println("\n Service Providers \n\t");
        // serviceList.forEach(data -> System.out.println(data.getContact_number()));
        if(request.getSession().getAttribute("userName")!=null){
            
            String user = request.getSession().getAttribute("userName").toString();
            int userId = Integer.parseInt(user);
            String userName = userRepo.findById(userId).getName();
            model.addAttribute("userName", userName);

            if(request.getParameter("search")==null){
                List<ServiceProvider> serviceList = serviceProviderRepo.findAll();
                model.addAttribute("serviceList", serviceList);
                List<String> list = new ArrayList<String>();
                for (int i = 0; i < serviceList.size(); i++) {
                    list.add(serviceList.get(i).getService_name());
                }
                model.addAttribute("list", list);
            }else{
                List<ServiceProvider> searchServiceList = serviceProviderRepo.findByServiceName(request.getParameter("search").toLowerCase());
                if(searchServiceList.size()==0){
                    // TODO: Add msg that no result found
                    List<ServiceProvider> serviceList = serviceProviderRepo.findAll();
                    model.addAttribute("serviceList", serviceList);
                    List<String> list = new ArrayList<String>();
                    for (int i = 0; i < serviceList.size(); i++) {
                        list.add(serviceList.get(i).getService_name());
                    }
                    model.addAttribute("list", list);
                }else{
                    model.addAttribute("serviceList", searchServiceList);
                    List<ServiceProvider> serviceList = serviceProviderRepo.findAll();
                    List<String> list = new ArrayList<String>();
                    for (int i = 0; i < serviceList.size(); i++) {
                        list.add(serviceList.get(i).getService_name());
                    }
                    model.addAttribute("list", list);
                }
            }
            
            ServiceProvider service = new ServiceProvider(); 
            model.addAttribute("service", service);
            return "landing";
        }else{
            return "redirect:/forbidden";
        }
    }

    @PostMapping("/search")
    public String search(@ModelAttribute("service") ServiceProvider service) {
        System.out.println("Test1\t" + service.getService_name());
        return "redirect:/landing?search="+service.getService_name();
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
            model.addAttribute("serviceList", serviceList);
//            UserDetails details= new UserDetails();
//            model.addAttribute("userDetails",details);
//            List<UserDetails> details= userProfile.findById(userId);
            String name = userProfile.findById(userId).getName();
            String mail = userRepo.findById(userId).getEmail();
            String pass = userRepo.findById(userId).getPassword();
            System.out.println("test2"+ name);
            System.out.println("test3"+ mail);
            System.out.println("test3"+ pass);
            model.addAttribute("id", userId);
            model.addAttribute("name",name);
            model.addAttribute("email",mail);
            model.addAttribute("password",pass);

            UserDetails userModel = new UserDetails();
            model.addAttribute("details", userModel);
            List<OrderDetails> orderList = userProfile.findById(userId).getOrderDetails();
            // System.out.println(orderList.get(1).getStatus());
            // List<OrderDetails> orderList = userRepo.findOrderDetailsById(userId);
            model.addAttribute("orderList", orderList);
            model.addAttribute("feed", new OrderDetails());
            // model.addAttribute("userProfile" , details);
            return "userProfile";
        }
        else {
            return "redirect:/forbidden";
        }
    }

    @PostMapping("/detailsUpdate")
    public String updateUser(@ModelAttribute("details") UserDetails user,@ModelAttribute("id") String Id, Model model, HttpServletRequest request) {
//        if (result.hasErrors()) {
//            user.setId(id);
//            return "update-user";
//        }
        // Changing String Id to int id
        //TODO:Check again if this works
        // System.out.println("test4"+ Id);
        // int id = Integer.parseInt(Id);
        String userId = request.getSession().getAttribute("userName").toString();
        int id = Integer.parseInt(userId);
        System.out.println(user.getName());
        UserDetails updatedUser = userRepo.findById(id);
        if (!user.getName().isEmpty()) {
            updatedUser.setName(user.getName());
        }
        if (!user.getEmail().isEmpty()) {
            updatedUser.setEmail(user.getEmail());
        }
        if (!user.getPassword().isEmpty()) {
            updatedUser.setPassword(user.getPassword());
        }
        // userRepo.save(updatedUser);
        // userRepo.save(details);
        // model.addAttribute("details", userRepo.findAll());
        return "redirect:/userProfile";
    }


    @PostMapping("/feedbackUpdate" )
    public String updateFeedback(@ModelAttribute("feed") OrderDetails order, Model model,
                                 HttpServletRequest request  )
    {
//        String userId = request.getSession().getAttribute("userName").toString();
//        int id = Integer.parseInt(userId);
        int id1= order.getId();
//
        System.out.println("testblah"+id1);
        OrderDetails updatedFeed = orderDetailsRepo.findById(order.getId());
        updatedFeed.setFeedback(order.getFeedback());
        updatedFeed.setRating(order.getRating());
        return "redirect:/userProfile";
    }
    private static Date parseDate(String date) {
        try {
//            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    @PostMapping("/orderService")
    public String orderService(@ModelAttribute("orderForm") OrderForm orderForm, OrderDetails order, Model model,
                               HttpServletRequest request) {
        // System.out.println(
        // orderForm.getUserName() + "::" + orderForm.getServiceId() + "::" +
        // orderForm.getAddress() + "::\n");
        String userId = request.getSession().getAttribute("userName").toString();
        int id = Integer.parseInt(userId);
        UserDetails user = userRepo.findById(id);
        ServiceProvider service = serviceProviderRepo.findById(orderForm.getServiceId());
        // // // //
        System.out.println("::\n" + service.getService_name() + "::" + service.getContact_name() + "::\n");
        System.out.println("::\n" + user.getEmail() + "::" + user.getName() + "::" + user.getOrderDetails().toString()
                + "::" + user.getId() + "::\n");
        // // // //
        OrderDetails newOrder = new OrderDetails();
        newOrder.setUser(user);
        newOrder.setService(service);
        newOrder.setStatus(orderForm.getStatus());
        newOrder.setAddress(orderForm.getAddress());
        System.out.println("Date"+orderForm.getServiceDate());
        System.out.println("Time"+orderForm.getServiceTime());
        String d=orderForm.getServiceDate()+" " +orderForm.getServiceTime() +":00";
        System.out.println("str"+d);
        Date date1= parseDate(d);
        System.out.println("dateobject"+ date1.getTime());
//        newOrder.setServiceTime(orderForm.getServiceTime());
//        newOrder.setServiceDate(orderForm.getServiceDate());
//            Date d2=new Date();
//            System.out.println("curr"+d2);
//        if(d2.getTime() >= date1.getTime());
//        {
//
//        }
        newOrder.setServiceTimestamp(date1);
        Date date=new Date();
        newOrder.setOrderTimestamp(date);
        OrderDetails savedOrder = orderDetailsRepo.save(newOrder);
        System.out.println("\nSAVED ORDER ID: " + savedOrder.getId() + "\n");
        return "redirect:/userProfile";
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
        if(request.getSession().getAttribute("userName") != null){
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
            } model.addAttribute("orderForm", new OrderForm());
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

    // @RequestMapping(value="/search")
    // @ResponseBody
    // public List<String> search(@RequestParam(value="term", required= false, defaultValue = "")String term){
    //     List<String> list = new ArrayList<String>();
    //     list.add("Akshat");
    //     list.add("Anshika");
    //     list.add("Choi");
    //     list.add("Vaibhav");
    //     return list;
    // }


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