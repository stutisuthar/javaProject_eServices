package com.project.services.service;

import com.project.services.model.UserDetails;
import com.project.services.repository.userDetailsRepository;

import org.springframework.beans.BeanUtils;
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
        // UserDetails insRow = new UserDetails();
        // // insRow = data;
        // BeanUtils.copyProperties(data, insRow);
        // insRow.setId(data.getId());
        // insRow.setName(data.getName());
        // insRow.setPassword(data.getPassword());
        // insRow.setEmail(data.getEmail());
        try {
            System.out.println(data);
            userDetailsRepo.save(data);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String AuthenticateUser(UserDetails data) {
        // UserDetails details = new UserDetails();
        // int auth = 0;
        // insRow.setName(data.getName());
        // insRow.setPassword(data.getPassword());
        // insRow.setEmail(data.getEmail());
        try {
            String email = userDetailsRepo.findByEmail(data.getEmail()).getEmail();
            String password = userDetailsRepo.findByEmail(data.getEmail()).getPassword(); 
            String name = userDetailsRepo.findByEmail(data.getEmail()).getName();
            System.out.println(email+" and "+ data.getPassword());
            if(password.contentEquals(data.getPassword())){
                System.out.println(name);
                // auth = 1;
                return name;
            }else{
                return "invalid";
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return "error";
        }
        // return "false";
    }
}