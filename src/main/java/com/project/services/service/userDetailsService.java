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
        UserDetails insRow = new UserDetails();
        // insRow = data;
        BeanUtils.copyProperties(data, insRow);
        // insRow.setId(data.getId());
        // insRow.setName(data.getName());
        // insRow.setPassword(data.getPassword());
        // insRow.setEmail(data.getEmail());
        try {
            System.out.println(insRow);
            userDetailsRepo.save(insRow);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String AuthenticateUser(UserDetails data) {
        UserDetails details = new UserDetails();
        int auth = 0;
        // insRow.setName(data.getName());
        // insRow.setPassword(data.getPassword());
        // insRow.setEmail(data.getEmail());
        try {
            details = userDetailsRepo.findByEmail(data.getEmail());
            System.out.println(details.getPassword()+" and "+ data.getPassword());
            if(details.getPassword().contentEquals(data.getPassword())){
                System.out.println(details.getName());
                auth = 1;
                return details.getName();
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