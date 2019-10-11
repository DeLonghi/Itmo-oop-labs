package com.company.Entities;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductInfo {
    private String ProductName;
    private ArrayList<Integer> id;
    private ArrayList<Integer> quantity;
    private ArrayList<Float> price;

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public ArrayList<Integer> getId() {
        return id;
    }

    public void setId(ArrayList<Integer> id) {
        this.id = id;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Float> getPrice() {
        return price;
    }

    public void setPrice(ArrayList<Float> price) {
        this.price = price;
    }
}

