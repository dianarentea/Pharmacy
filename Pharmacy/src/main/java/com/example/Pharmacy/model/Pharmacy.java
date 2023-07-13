package com.example.Pharmacy.model;

import java.util.List;

public class Pharmacy {

    private String name;

    List<Pill> pillList;


    public Pharmacy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

