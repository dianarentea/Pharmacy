package com.example.Pharmacy.model;

import jakarta.persistence.*;


@Entity
@Table(name="t_pill")
public class Pill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
    @Column(name="stockNumber")
    private int stockNumber;
    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="id_pharmacy")
    private Pharmacy pharmacy;

    public Pill()
    {}

    public Pill(int id,String name, double price, int stockNumber, String description, Pharmacy pharmacy) {
        this.id=id;
        this.name = name;
        this.price = price;
        this.stockNumber = stockNumber;
        this.description = description;
        this.pharmacy=pharmacy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    @Override
    public String toString() {
        return "Pill{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stockNumber=" + stockNumber +
                ", description='" + description + '\'' +
                ", pharmacy=" + pharmacy +
                '}';
    }
}
