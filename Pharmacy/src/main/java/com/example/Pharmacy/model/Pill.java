package com.example.Pharmacy.model;

public class Pill {
    private String name;
    private int price;
    private int stockNumber;
    private String description;

    public Pill(String name, int price, int stockNumber, String description) {
        this.name = name;
        this.price = price;
        this.stockNumber = stockNumber;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
