package com.project.services.service;

import com.project.services.model.ServiceProvider;
import com.project.services.repository.AddServiceProviderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class addServiceToDB {
    @Autowired
    private AddServiceProviderRepository serviceProviderRepo;

    public Boolean SaveServicesData(ServiceProvider data) {
        ServiceProvider insRow = new ServiceProvider();
        // insRow = data;
        BeanUtils.copyProperties(data, insRow);
        // insRow.setId(data.getId());
        // insRow.setName(data.getName());
        // insRow.setPassword(data.getPassword());
        // insRow.setEmail(data.getEmail());
        try {
            System.out.println(insRow);
            serviceProviderRepo.save(insRow);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
