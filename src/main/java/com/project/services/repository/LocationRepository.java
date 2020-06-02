package com.project.services.repository;

// import java.util.List;

import com.project.services.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository <Location, Long>{
    // Location findLocationById(int id);
    Location findById(int id);
    Location findBylocName(String locString);
    // Location findByLocation(String loc_name);
    // List<Location> findLocationById(int id);
}