package com.company;

import com.company.DAO.FileDAO;
import com.company.Entities.ProductInfo;
import com.company.Entities.ShopInfo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FileDAO fd = new FileDAO("C:\\Users\\vinni\\IdeaProjects\\OOP4\\src\\com\\company\\Data\\Shops.csv", "C:\\Users\\vinni\\IdeaProjects\\OOP4\\src\\com\\company\\Data\\Products.csv");
//        fd.addProduct("Марковка");
//        fd.StockUp(5, "Арбуз", 0, (float) 45.11);
//        ProductInfo pf = new ProductInfo();
        ShopInfo si = new ShopInfo();
        si = fd.getShopInfo(2);
        for (int i = 0; i < si.getProduct().size(); i++) {
            System.out.println(si.getProduct().get(i));
        }
    }
}
