package com.project.services.service;

import com.project.services.model.OrderDetails;
import com.project.services.repository.OrderDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepo;

    public boolean newOrderEntry(OrderDetails order) {
        try {
            orderDetailsRepo.save(order);
        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage() + " : : " + e.getStackTrace());
            return false;
        }
        return true;
    }
}