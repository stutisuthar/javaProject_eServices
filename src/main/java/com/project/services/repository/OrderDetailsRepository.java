package com.project.services.repository;

import com.project.services.model.OrderDetails;
import com.project.services.model.UserDetails;

import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    // List<OrderDetails> findByUserId_User(int id);
    OrderDetails findById(int id);
}