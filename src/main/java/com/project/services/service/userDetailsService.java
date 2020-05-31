package com.project.services.service;

import com.project.services.model.UserDetails;
import com.project.services.repository.userDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Session Management
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpSession;

@Service
public class userDetailsService {
    
    @Autowired
    private userDetailsRepository userDetailsRepo;

    public Boolean SaveUserData(UserDetails data) {
        UserDetails insRow = new UserDetails();
        insRow.setName(data.getName());
        insRow.setPassword(data.getPassword());
        insRow.setEmail(data.getEmail());
        insRow.setOrderDetails(data.getOrderDetails());
        try {
            userDetailsRepo.save(insRow);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String AuthenticateUser(UserDetails data) {
        UserDetails details = new UserDetails();
        // insRow.setName(data.getName());
        // insRow.setPassword(data.getPassword());
        // insRow.setEmail(data.getEmail());
        try {
            details = userDetailsRepo.findByEmail(data.getEmail());
            System.out.println(details.getName());
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return "false";
        }
        return details.getName();
    }
}