package com.example.defenceline.model;

public class Invoice {

    private String date, invoiceNumber, name, itemNumber, serviceType, quantity, accountant, price, total, discount;

    public Invoice() {
    }

    public Invoice(String date, String invoiceNumber, String name, String itemNumber, String serviceType,
                   String quantity, String accountant, String price, String total, String discount) {
        this.date = date;
        this.invoiceNumber = invoiceNumber;
        this.name = name;
        this.itemNumber = itemNumber;
        this.serviceType = serviceType;
        this.quantity = quantity;
        this.accountant = accountant;
        this.price = price;
        this.total = total;
        this.discount = discount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
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

    public String getAccountant() {
        return accountant;
    }

    public void setAccountant(String accountant) {
        this.accountant = accountant;
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
