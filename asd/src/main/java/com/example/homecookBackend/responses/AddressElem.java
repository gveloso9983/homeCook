package com.example.homecookBackend.responses;

import com.example.homecookBackend.classes.address.Address;

public class AddressElem {
    private int id;

    private String street;

    private String postalCode;

    private String city;

    public AddressElem(int id, String street, String postalCode,String city){
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
