package com.example.defenceline.model;

public class Company {

    private String name, phoneNo, location, price, id;

    public Company() {
    }

    public Company(String name, String phoneNo, String location, String price, String id) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.location = location;
        this.price = price;
        this.id = id;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
