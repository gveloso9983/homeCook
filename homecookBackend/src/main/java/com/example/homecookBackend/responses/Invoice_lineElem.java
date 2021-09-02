package com.example.homecookBackend.responses;

import com.example.homecookBackend.classes.product.Product;

public class Invoice_lineElem {

    private int id;

    private int productId;

    private String productName;

    private int quantity;

    private boolean done;

    private float price;

    public Invoice_lineElem(int id, int productId, String productName, int quantity, boolean done, float price){
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.done = done;
        this.price = price;
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
