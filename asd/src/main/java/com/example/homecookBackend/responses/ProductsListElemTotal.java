package com.example.homecookBackend.responses;

import java.util.ArrayList;

public class ProductsListElemTotal {
    public ProductsListElemTotal(int total, ArrayList<ProductListElem> productListElem) {
        this.total = total;
        this.productListElem = productListElem;
    }

    private int total;
    private ArrayList<ProductListElem> productListElem;
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<ProductListElem> getProductListElem() {
        return productListElem;
    }

    public void setProductListElem(ArrayList<ProductListElem> productListElem) {
        this.productListElem = productListElem;
    }







}
