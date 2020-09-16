package com.example.defenceline.model;

public class Company {

    private String name, phoneNo, location, date, time, serviceType, price;

    public Company() {
    }

    public Company(String name, String phoneNo, String location, String date, String time, String serviceType, String price) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.location = location;
        this.date = date;
        this.time = time;
        this.serviceType = serviceType;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
