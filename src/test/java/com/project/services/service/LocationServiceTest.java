package com.project.services.service;

import com.project.services.model.Location;
import com.project.services.repository.LocationRepository;
import com.project.services.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LocationServiceTest {
  
  @Test(groups = { "checkin" })
  public void testGetDetails()
  {
    LocationService locationService = new LocationService();
    Assert.assertNotNull(locationService.getDetails(5));
  }
}
    
