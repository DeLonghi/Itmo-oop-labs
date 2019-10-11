package com.company.Entities;

import java.util.ArrayList;

public class ShopInfo {
    private int ShopId;
    private ArrayList<String> product;
    private ArrayList<Integer> quantity;
    private ArrayList<Float> price;

    public int getShopId() {
        return ShopId;
    }

    public void setShopId(int shopId) {
        ShopId = shopId;
    }

    public ArrayList<String> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<String> product) {
        this.product = product;
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
