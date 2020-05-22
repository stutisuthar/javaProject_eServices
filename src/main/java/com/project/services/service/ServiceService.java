package com.project.services.service;

import com.project.services.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public Boolean insertRow(Map<String, String> payload)
    {
        com.project.services.model.Service insRow= new com.project.services.model.Service();
        insRow.setName(payload.get("name"));
        insRow.setPassword(payload.get(("password")));
        insRow.setEmail(payload.get("email"));
        try {
            serviceRepository.save(insRow);
        }
        catch (Exception e){
            return false;
        }
        return true;

    }
    public List<com.project.services.model.Service> getData(){
        return serviceRepository.findAll();
    }

}
