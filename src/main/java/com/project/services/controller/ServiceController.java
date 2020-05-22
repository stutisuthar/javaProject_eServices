package com.project.services.controller;

import com.project.services.model.Service;
import com.project.services.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ServiceController {

    @Autowired
    private ServiceService eservice;

    @RequestMapping(value="/postData" , method = RequestMethod.POST, produces = "application/json")
    public Boolean insert(@RequestBody Map<String,String> payload){
        return eservice.insertRow(payload);
    }
    @GetMapping("/get")
    public List<Service> getData(){
        return eservice.getData();
    }
}
