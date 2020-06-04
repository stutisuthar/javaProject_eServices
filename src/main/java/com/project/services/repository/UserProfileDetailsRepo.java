package com.project.services.repository;

import com.project.services.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sun.nio.cs.US_ASCII;

import java.util.List;


@Repository
public interface UserProfileDetailsRepo extends JpaRepository <UserDetails, Long> {
    UserDetails findById(int id);
}
