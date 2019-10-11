package com.company.DAO;

import com.company.Entities.ProductInfo;
import com.company.Entities.ShopInfo;
import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;


public class FileDAO implements GetData {
    private String s_path;
    private String p_path;
    private String line;
    private FileReader s_file;
    private FileReader p_file;
    private BufferedReader br;

    public FileDAO(String _s_path, String _p_path) {
        try {
            this.s_path = _s_path;
            this.p_path = _p_path;
            s_file = new FileReader(s_path);
            br = new BufferedReader(s_file);
            p_file = new FileReader(p_path);
            br = new BufferedReader(p_file);
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public boolean addProduct(String ProductName) {
        try {
            String line;

            br = new BufferedReader(new FileReader(p_path));

            while ((line = br.readLine()) != null) {
                if (line.matches("^" + ProductName)) {
                    return false;

                }
            }
            br.close();
            BufferedWriter fw = new BufferedWriter(new FileWriter(new File(p_path), true));
            fw.write("\n" + ProductName);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean addShop(int ShopId, String ShopName) {
        try {
            String line;

            br = new BufferedReader(new FileReader(s_path));

            while ((line = br.readLine()) != null) {
                String l[] = line.split(",", 2);
                if (Integer.parseInt(l[0]) == ShopId || l[1].equals(ShopName)) {
                    return false;

                }
            }

            br.close();
            BufferedWriter fw = new BufferedWriter(new FileWriter(new File(s_path), true));
            fw.write("\n" + line);

            fw.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return true;
    }

    @Override
    public boolean StockUp(int ShopId, String product, int quantity, float price) {
        try {
            String line;
            String result = "";
            int _quantity;
            br = new BufferedReader(new FileReader(p_path));

            while ((line = br.readLine()) != null) {
                if (line.matches("^" + product + ".*")) {
                    System.out.println("11111");
                    if (line.matches("^" + product + ".+" + ShopId + ",\\d+,\\d+\\.\\d+")) {
                        System.out.println("*******");
                        String[] l = line.split(",", 4);
                        _quantity = Integer.parseInt(l[2]);
                        _quantity += quantity;
                        System.out.println(_quantity);
                        line = line.replaceFirst("" + ShopId + ",\\d+,\\d+\\.\\d*", ShopId + "," + _quantity + "," + price);
                    } else {
                        System.out.println(line);
                        line += "," + ShopId + "," + quantity + "," + price;

                    }
                }
                result += line + "\n";
            }
            br.close();

            BufferedWriter fw = new BufferedWriter(new FileWriter(new File(p_path), false));
            fw.write(result);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return true;

    }

    public ProductInfo getProdcutInfo(String product) {
        ArrayList<Integer> id = new ArrayList<>();
        ArrayList<Integer> quiantity = new ArrayList<>();
        ArrayList<Float> price = new ArrayList<>();
        String line;
        ProductInfo productInfo = new ProductInfo();
        try {

            br = new BufferedReader(new FileReader(p_path));


            while ((line = br.readLine()) != null) {
                System.out.println(line);
                if (line.matches("^" + product + ".*")) {
                    String[] l = line.split(",", 2);
                    String[] info = l[1].split(",");
                    System.out.println(info[3]);

                    for (int i = 0; i < info.length; i += 3) {
                        id.add(Integer.parseInt(info[i]));
                        quiantity.add(Integer.parseInt(info[i + 1]));
                        price.add(Float.parseFloat(info[i + 2]));
                    }
                    productInfo.setProductName(product);
                    productInfo.setId(id);
                    productInfo.setQuantity(quiantity);
                    productInfo.setPrice(price);
                    br.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        System.out.println(productInfo.getProductName());
        return productInfo;
    }

    public ShopInfo getShopInfo(int Shop_Id) {
        ArrayList<String> product = new ArrayList<>();
        ArrayList<Integer> quantity = new ArrayList<>();
        ArrayList<Float> price = new ArrayList<>();
        ShopInfo si = new ShopInfo();
        int i;
        int id;
        try {

            br = new BufferedReader(new FileReader(p_path));

            while ((line = br.readLine()) != null) {
                if (line.matches(".+" + Shop_Id + ",\\d+,\\d+\\.\\d+")) {
                    System.out.println("asdasd");
                    String[] l = line.split(",");
                    System.out.println(l[0]);
                    product.add(l[0]);
                    id = -1;
                    i = 0;
                    while (id != Shop_Id) {
                        id = Integer.parseInt(l[1 + i]);
                        i += 3;
                    }
                    i -= 3;
                    System.out.println(id + " " + i);
                    quantity.add(Integer.parseInt(l[2 + i]));
                    price.add(Float.parseFloat(l[3 + i]));

                }
            }
            br.close();
            si.setProduct(product);
            si.setQuantity(quantity);
            si.setPrice(price);


        } catch (IOException e) {
            e.printStackTrace();

        }
        return si;
    }

}
