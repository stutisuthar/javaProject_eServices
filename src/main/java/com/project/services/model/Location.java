package com.project.services.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "locationName")
    private String locName;

    @OneToMany(mappedBy="location", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<ServiceProvider> serviceProvider;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    @Override
    public String toString(){
        return id+locName;
    }

    // public Set<ServiceProvider> getServiceProvider() {
    //     return serviceProvider;
    // }

    // public void setServiceProvider(Set<ServiceProvider> serviceProvider) {
    //     this.serviceProvider = serviceProvider;
    // }
}
