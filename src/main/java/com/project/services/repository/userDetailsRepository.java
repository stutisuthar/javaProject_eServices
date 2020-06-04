package com.project.services.repository;

// import java.util.List;

import com.project.services.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userDetailsRepository extends JpaRepository<UserDetails, Long> {
    UserDetails findByEmail(String email);
    UserDetails findById(int id);
    // UserDetails findByEmailPassword(String email, String password);
}