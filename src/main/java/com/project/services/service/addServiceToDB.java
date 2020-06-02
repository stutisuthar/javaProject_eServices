package com.project.services.service;

import com.project.services.model.Location;
import com.project.services.model.ServiceProvider;
import com.project.services.repository.AddServiceProviderRepository;
import com.project.services.repository.LocationRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class addServiceToDB {
    
    @Autowired
    private AddServiceProviderRepository serviceProviderRepo;
    @Autowired
    private LocationRepository locationRepo;

    public Boolean SaveServicesData(ServiceProvider service, Location location) {
        try {
            String locName = location.getLocName();
            // System.out.println("test2: " + location.getId());
            // System.out.println("test2: " + location.getLocName());
            service.setLocation(locationRepo.findBylocName(locName));
            System.out.println("Service:\t" + service.toString());
            System.out.println(service.getLocation().getLocName());
            serviceProviderRepo.save(service);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

}
