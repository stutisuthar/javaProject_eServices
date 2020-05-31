package com.project.services.model;

import com.project.services.repository.ServiceRepository;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ServiceProvider")
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name= "serviceName")
    private String service_name;

    @Column(name = "serviceCat")
    private String serviceCategory;

    @Column(name="contactName")
    private String contact_name;

    @Column(name = "contactNumber")
    private String contact_number;


    @Column(name = "cost")
    private int cost;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locName" ,nullable = false)
    private Location location;

    public String getLocation() {
        return location.getLocName();
    }

    public void setLocation(String location) {
        this.location.setLocName(location);
    }

    @OneToMany(mappedBy="service", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<OrderDetails> orderDetails;

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
