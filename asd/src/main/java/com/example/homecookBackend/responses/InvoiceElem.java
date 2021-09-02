package com.example.homecookBackend.responses;

import java.util.Date;
import java.util.stream.Stream;

public class InvoiceElem {
    private int id;

    private String street;

    private String city;

    private float total;

    private java.util.Date date;

    public InvoiceElem(int id, String street, String city, float total, java.util.Date data){
        this.id = id;
        this.street = street;
        this.city = city;
        this.total = total;
        this.date = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
