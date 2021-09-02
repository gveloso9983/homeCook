package com.example.homecookBackend.responses;

import com.example.homecookBackend.classes.address.Address;
import com.example.homecookBackend.controllers.Invoice;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceDetails {
    private int id;

    private AddressElem address;

    private float total;

    private java.util.Date date;

    private ArrayList<Invoice_lineElem> items;

    public InvoiceDetails(int id, AddressElem address, float total, java.util.Date date, ArrayList<Invoice_lineElem> items){
        this.id = id;
        this.address = address;
        this.total = total;
        this.date = date;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<Invoice_lineElem> getItems() {
        return items;
    }

    public void setItems(ArrayList<Invoice_lineElem> items) {
        this.items = items;
    }

    public AddressElem getAddress() {
        return address;
    }

    public void setAddress(AddressElem address) {
        this.address = address;
    }
}
