package com.example.defenceline.model;

public class Invoice {

    private String billNo, name, date, serviceType, quantity, price, total, accountant;

    public Invoice() {
    }

    public Invoice(String billNo, String name, String date, String serviceType, String quantity, String price, String total, String accountant) {
        this.billNo = billNo;
        this.name = name;
        this.date = date;
        this.serviceType = serviceType;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.accountant = accountant;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getAccountant() {
        return accountant;
    }

    public void setAccountant(String accountant) {
        this.accountant = accountant;
    }
}
