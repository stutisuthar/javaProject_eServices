package com.project.services.repository;

import com.project.services.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileDetailsRepo extends JpaRepository <UserDetails, Long> {
    UserDetails findById(int id);
}
