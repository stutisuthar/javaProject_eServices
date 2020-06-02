package com.project.services.service;

import com.project.services.model.ServiceProvider;
import com.project.services.repository.ServiceProviderRepository;
import com.project.services.repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class addServiceToDB {
    @Autowired
    private ServiceProviderRepository serviceProviderRepo;
    @Autowired
    private LocationRepository locationRepo;

    public Boolean SaveServicesData(ServiceProvider service) {
        try {
            System.out.println(locationRepo.findAll());
            service.setLocation(locationRepo.findById(3));
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
