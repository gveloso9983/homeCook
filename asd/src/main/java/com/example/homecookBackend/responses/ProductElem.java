package com.example.homecookBackend.responses;

import com.example.homecookBackend.classes.baker.Baker;
import com.example.homecookBackend.classes.category.Category;

import java.util.ArrayList;

public class ProductElem {
    private int id;

    private int category_id;

    private String name;

    private String description;

    private String ingredients;

    private float price;

    private float weight;

    private float rating;

    private ArrayList<CommentElem> comments;

    private ArrayList<Integer> images;

    private boolean onSale;

    public ProductElem(int id,int category_id, String name, String description, String ingredients, float price, float weight, float rating, ArrayList<CommentElem> comments, ArrayList<Integer> images, boolean onSale){
        this.id =id;
        this.category_id = category_id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.price = price;
        this.weight = weight;
        this.rating = rating;
        this.comments = comments;
        this.images = images;
        this.onSale = onSale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
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

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
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

    public ArrayList<Integer> getImages() {
        return images;
    }

    public void setImages(ArrayList<Integer> images) {
        this.images = images;
    }

    public ArrayList<CommentElem> getComments() {
        return comments;
    }

    public void setComments(ArrayList<CommentElem> comments) {
        this.comments = comments;
    }

    public boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }
}
