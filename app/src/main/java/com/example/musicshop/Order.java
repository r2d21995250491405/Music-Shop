package com.example.musicshop;

public class Order {
    String username;
    String goodsname;
    int quant;
    double priceforine;
    double price;

    public Order(String username, String goodsname, int quant, double price) {
        this.username = username;
        this.goodsname = goodsname;
        this.quant = quant;
        this.price = price;
    }

    public Order() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
