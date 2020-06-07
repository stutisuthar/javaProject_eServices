package com.project.services.service;

import com.project.services.model.Location;
// import com.project.services.model.ServiceProvider;
// import com.project.services.repository.ServiceProviderRepository;
import com.project.services.repository.LocationRepository;

// import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepo;

    public Location getDetails(int id){
        // locationRepo.findById(id);
        return  locationRepo.findById(id);
    }
}