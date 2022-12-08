package com.ute.ecwebapp3.beans;

public class Product {
    private int ProID;
    private  String ProName, TinyDes,FullDes;
    private int Price,Quantity, CatID;


    public Product() {

    }



    public Product(int proID, String proName, String tinyDes, String fullDes, int price, int quantity, int catID) {
        ProID = proID;
        ProName = proName;
        TinyDes = tinyDes;
        FullDes = fullDes;
        Price = price;
        Quantity = quantity;
        CatID = catID;
    }

    public int getProID() {
        return ProID;
    }

    public void setProID(int proID) {
        ProID = proID;
    }

    public String getProName() {
        return ProName;
    }

    public void setProName(String proName) {
        ProName = proName;
    }

    public String getTinyDes() {
        return TinyDes;
    }

    public void setTinyDes(String tinyDes) {
        TinyDes = tinyDes;
    }

    public String getFullDes() {
        return FullDes;
    }

    public void setFullDes(String fullDes) {
        FullDes = fullDes;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getCatID() {
        return CatID;
    }

    public void setCatID(int catID) {
        CatID = catID;
    }
}

