package com.project.services.repository;

import com.project.services.model.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

    // @Query(value="insert into public.service_provider(id, contact_name,
    // contact_number, cost, service_cat, service_name, loc_name) values(:id,
    // :contact_name, :contact_number, :cost, :service_cat, :service_name,
    // :loc_name)", nativeQuery = true)
    // void insertService(@Param("id") int id, @Param("contact_name") String
    // contact_name, );

    public List<ServiceProvider> findAll();
}
