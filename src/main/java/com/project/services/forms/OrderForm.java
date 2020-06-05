package com.project.services.forms;

public class OrderForm {

    private int serviceId;

    private String userName;

    private String address;

    private String status;

    public int getServiceId() {
        return serviceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

}