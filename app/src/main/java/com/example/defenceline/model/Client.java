package com.example.defenceline.model;

public class Client {

    private String invoiceDate, invoiceNumber, name, phoneNo, location, itemNumber, quantity, accountant, date, time, serviceType, price, total, discount;

    public Client() {
    }

    public Client(String invoiceDate, String invoiceNumber, String name, String phoneNo, String location, String itemNumber,
                  String quantity, String accountant, String date, String time, String serviceType, String price, String total, String discount) {
        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber;
        this.name = name;
        this.phoneNo = phoneNo;
        this.location = location;
        this.itemNumber = itemNumber;
        this.quantity = quantity;
        this.accountant = accountant;
        this.date = date;
        this.time = time;
        this.serviceType = serviceType;
        this.price = price;
        this.total = total;
        this.discount = discount;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
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

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAccountant() {
        return accountant;
    }

    public void setAccountant(String accountant) {
        this.accountant = accountant;
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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
