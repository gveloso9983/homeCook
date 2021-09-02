package com.example.homecookBackend.responses;

import java.util.Date;

public class OrderElem {
    private int id;
    private int productId;
    private String productName;
    private int quantity;
    private java.util.Date deliveryDate;
    private AddressElem address;

    public OrderElem(int id, int productId, String productName, int quantity, java.util.Date deliveryDate, AddressElem address){
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
        this.address = address;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public AddressElem getAddress() {
        return address;
    }

    public void setAddress(AddressElem address) {
        this.address = address;
    }
}
