package com.project.services.repository;

import com.project.services.model.OrderDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    // List<OrderDetails> findByUserId_User(int id);
    OrderDetails findById(int id);
}