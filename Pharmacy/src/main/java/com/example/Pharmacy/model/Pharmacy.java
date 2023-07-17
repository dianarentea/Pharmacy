package com.example.Pharmacy.model;

public class Pharmacy {

    private String name;

    public Pharmacy(String name) {
        this.name = name;
    }

    public Pharmacy() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Pharmacy{" +
                "name='" + name + '\'' +

                '}';
    }
}

