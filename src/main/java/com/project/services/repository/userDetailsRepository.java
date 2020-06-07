package com.project.services.repository;

import com.project.services.model.OrderDetails;

// import java.util.List;

import com.project.services.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Repository
public interface userDetailsRepository extends JpaRepository<UserDetails, Long> {
    UserDetails findByEmail(String email);
    UserDetails findById(int id);

    List<OrderDetails> findOrderDetailsById(int id);
    // UserDetails findByEmailPassword(String email, String password);
}