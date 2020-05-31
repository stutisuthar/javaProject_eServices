package com.project.services.repository;

import com.project.services.model.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {
}
