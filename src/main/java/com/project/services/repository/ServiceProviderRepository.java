package com.project.services.repository;

import com.project.services.model.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    public ServiceProvider findById(int id);
    
    // public ServiceProvider findServiceProvider(int id);
    @Query("select s from ServiceProvider s where s.service_name = :service_name")
    List<ServiceProvider> findByServiceName(@Param("service_name") String service_name);
    // public ServiceProvider findByServiceName(String service_name);
    // public List<ServiceProvider> findByService_Name(String service_name);
}
