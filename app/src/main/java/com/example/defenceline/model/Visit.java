package com.example.defenceline.model;

public class Visit {

    // vars
    String visitDate, visitNumber, name, placeHolder, serviceProvider, signature, date, notes, stamp;

    // constructors
    public Visit() {
    }

    public Visit(String visitDate, String visitNumber, String name, String placeHolder, String serviceProvider,
                 String signature, String date, String notes, String stamp) {
        this.visitDate = visitDate;
        this.visitNumber = visitNumber;
        this.name = name;
        this.placeHolder = placeHolder;
        this.serviceProvider = serviceProvider;
        this.signature = signature;
        this.date = date;
        this.notes = notes;
        this.stamp = stamp;
    }

    // getters & setters
    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(String visitNumber) {
        this.visitNumber = visitNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }
}
