package com.example.homecookBackend.responses;


import com.example.homecookBackend.classes.category.Category;

public class ProductListElem {
    private int id;

    private String name;

    private String description;

    private float price;

    private float weight;

    private float rating;

    private int id_image;

    private Category category;

    private boolean onSale;

    public ProductListElem(int id, String name, String description, float price, float weight, float rating, int id_image, Category category, boolean onSale){
        this.id =id;
        this.name=name;
        this.description=description;
        this.price = price;
        this.weight = weight;
        this.rating = rating;
        this.id_image = id_image;
        this.category = category;
        this.onSale = onSale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(boolean value) {
        this.onSale = value;
    }
}
