package com.project.services.repository;


import com.project.services.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository <Location,Integer>{
    Location findLocationById(int id);
    // findById(Integer )
}