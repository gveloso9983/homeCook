package com.example.homecookBackend.responses;

public class CartElem {
    private int id;
    private int idProd;
    private String name;
    private int quantity;
    private float price;
    private int imageId;

    public CartElem(int id, int idProd, String name, int quantity, float price, int imageId){
        this.id=id;
        this.idProd = idProd;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
