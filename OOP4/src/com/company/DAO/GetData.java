package com.company.DAO;

import javafx.util.Pair;

import java.util.ArrayList;

public interface GetData {
    boolean addProduct(String ProductName);

    boolean addShop(int ShopId, String ShopName);

    boolean StockUp(int ShopId, String product, int quantity, float price);


}
