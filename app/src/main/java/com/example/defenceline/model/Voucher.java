package com.example.defenceline.model;

public class Voucher {

    private String voucherDate, voucherNumber, name, sumOf, paymentMethod, bankName, transferDate, providedService, receiverName;

    public Voucher() {
    }

    public Voucher(String voucherDate, String voucherNumber, String name, String sumOf, String paymentMethod,
                   String bankName, String transferDate, String providedService, String receiverName) {
        this.voucherDate = voucherDate;
        this.voucherNumber = voucherNumber;
        this.name = name;
        this.sumOf = sumOf;
        this.paymentMethod = paymentMethod;
        this.bankName = bankName;
        this.transferDate = transferDate;
        this.providedService = providedService;
        this.receiverName = receiverName;
    }

    //Getters and Setters
    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSumOf() {
        return sumOf;
    }

    public void setSumOf(String sumOf) {
        this.sumOf = sumOf;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
    }

    public String getProvidedService() {
        return providedService;
    }

    public void setProvidedService(String providedService) {
        this.providedService = providedService;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
}
