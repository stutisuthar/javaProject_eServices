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

    public Boolean SaveServicesData(ServiceProvider data) {
        try {
            Location loc = new Location();
            // loc = locationRepo.findLocationById(2);
            // Location loc = new Location();
            // loc.setId(2);
            loc.setId(2);
            data.setLocation(loc);
            System.out.println(data);
            serviceProviderRepo.save(data);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
