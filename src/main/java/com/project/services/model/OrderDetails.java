package com.project.services.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderDetails")
public class OrderDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "userDetails")
    private UserDetails userDetails;

    @Column(name = "s_Id")
    private int s_Id;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "rating")
    private int rating;

    @Column(name = "address")
    private String address;

    @Column(name = "Contact")
    private long contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public int getS_Id() {
        return s_Id;
    }

    public void setS_Id(int s_Id) {
        this.s_Id = s_Id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }
}




